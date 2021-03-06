package panawaapps.pantaupilkada.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.CardPostHomeAdapter;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.CardPostHome;
import panawaapps.pantaupilkada.model.Home.Comment;
import panawaapps.pantaupilkada.model.Home.Datum;
import panawaapps.pantaupilkada.model.PremiumReply;
import panawaapps.pantaupilkada.model.Status;
import panawaapps.pantaupilkada.model.UserData.UserData;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    List<Datum> cardPostHomes;
    RecyclerView rv_home;

    ApiAdapter apiAdapter;

    ProgressBar progressBar;

    SwipeRefreshLayout swipe;
    CardPostHomeAdapter adapterCardPostHome;
    ImageView ivApresiasi;

    int i = 0;

    String token;
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        apiAdapter = new ApiAdapter();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ivApresiasi = (ImageView) findViewById(R.id.iv_iconDiApresiasi);
//        ivApresiasi.setOnClickListener(this);

        SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(HomeActivity.this);
        token = settings.getString("token", "");
        editor = settings.edit();

        if (Objects.equals(token,"")){
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        }

        //untuk Konten activity
        rv_home = (RecyclerView) findViewById(R.id.rv_home);

        final LinearLayoutManager layoutCardHome = new LinearLayoutManager(this);
        rv_home.setLayoutManager(layoutCardHome);
        rv_home.setHasFixedSize(true);

        cardPostHomes = new ArrayList<>();



        cardPostHomes.clear();
        initializeData(1);

        adapterCardPostHome= new CardPostHomeAdapter(this, cardPostHomes, token);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refreshCardHome);

        rv_home.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = rv_home.getChildCount();
                totalItemCount = layoutCardHome.getItemCount();
                firstVisibleItem = layoutCardHome.findLastVisibleItemPosition();

                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading && (totalItemCount - visibleItemCount)
                        <= (firstVisibleItem + visibleThreshold)) {
                    // End has been reached

                    Log.i("Yaeye!", "end called");
                    i += 1;
                    initializeData(i);

                    // Do something

                    loading = true;
                }
            }
        });

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                cardPostHomes.clear();
                initializeData(1);
                progressBar.setVisibility(View.GONE);
            }
        });


    }

    private void initializeData(final int i){
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        apiAdapter.getRestApi().getComment(token, i, 50, new Callback<CardPostHome>() {
            @Override
            public void success(CardPostHome cardPostHome, Response response) {
                swipe.setRefreshing(false);
                rv_home.setAdapter(adapterCardPostHome);
                if (cardPostHome.getData().size() > 0) {
                    cardPostHomes.addAll(cardPostHome.getData());
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void failure(RetrofitError error) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }






    @Override
    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.iv_iconDiApresiasi:
//                sendApresiasi();
//                break;
//        }

    }


    //------Kebutuhan Navigation Drawer
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        //      MenuItem searchItem = menu.findItem(R.id.action_search);

        //     SearchManager searchManager = (SearchManager) HomeActivity.this.getSystemService(Context.SEARCH_SERVICE);

        //     SearchView searchView = null;
        //     if (searchItem != null) {
        //        searchView = (SearchView) searchItem.getActionView();
        //  }
        //if (searchView != null) {
        //searchView.setSearchableInfo(searchManager.getSearchableInfo(HomeActivity.this.getComponentName()));
        //}

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//
//        if (id == R.id.search_bar) {
//            return  true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id  = item.getItemId();

        if(id == R.id.nav_home) {
//            Intent myIntent = new Intent(HomeActivity.this, HomeActivity.class);
//
//            HomeActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengamat) {
            Intent myIntent = new Intent(HomeActivity.this, PengamatActivity.class);

            HomeActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengawas) {
//            Intent myIntent = new Intent(HomeActivity.this, PengawasActivity.class);
//
//            HomeActivity.this.startActivity(myIntent);
            Toast.makeText(getApplicationContext(), "Fitur ini tersedia pada Hari-H Pemilihan", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_saksi) {
//            Intent myIntent = new Intent(HomeActivity.this, SaksiActivity.class);
//
//            HomeActivity.this.startActivity(myIntent);
            Toast.makeText(getApplicationContext(), "Fitur ini tersedia pada Hari-H Pemilihan", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_kontestan) {

            Intent myIntent = new Intent(HomeActivity.this, DaftarKontestanActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            HomeActivity.this.startActivity(myIntent);

//        } else if (id == R.id.nav_group) {
//
//            Intent myIntent = new Intent(HomeActivity.this, DaftarGroupActivity.class);
//            //myIntent.putExtra("key", value); //Optional parameters
//            HomeActivity.this.startActivity(myIntent);


        } else if (id == R.id.nav_aboutMe) {

            Intent myIntent = new Intent(HomeActivity.this, AboutMeActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            HomeActivity.this.startActivity(myIntent);


//        } else if (id == R.id.nav_group_tentang) {
//
//            Intent myIntent = new Intent(HomeActivity.this, GroupTentang.class);
//            //myIntent.putExtra("key", value); //Optional parameters
//            HomeActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_logOut) {

            new AlertDialog.Builder(HomeActivity.this)
                    .setTitle("Log out?")
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            //keluar
//                            HomeActivity.this.getSharedPreferences("token", 0).edit().clear().commit();
//                            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
//                            startActivity(intent);
                            Status status = new Status();
                            apiAdapter.getRestApi().Logout(token, new Callback<Status>() {
                                @Override
                                public void success(Status status, Response response) {
                                    editor.remove("token");
                                    editor.commit();

                                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                }

                                @Override
                                public void failure(RetrofitError error) {

                                }
                            });





                        }
                    })
                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();
            return false;
//
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
