package panawaapps.pantaupilkada.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.CardTpsSaksiAdapter;
import panawaapps.pantaupilkada.adapter.TpsCardAdapter;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.CardTpsSaksi;
import panawaapps.pantaupilkada.model.Status;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SaksiActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    private List<CardTpsSaksi> cardTpsSaksiList;
    private RecyclerView rv_CardTpsSaksi;
    private CardTpsSaksiAdapter cardTpsSaksiAdapter;

    //utk fetching json
    private ApiAdapter apiAdapter;

    SharedPreferences settings;
    String token;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saksi);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //untuk Konten activity
        rv_CardTpsSaksi = (RecyclerView) findViewById(R.id.rv_cardTpsSaksi);

        LinearLayoutManager layoutCardHome = new LinearLayoutManager(this);
        rv_CardTpsSaksi.setLayoutManager(layoutCardHome);
        rv_CardTpsSaksi.setHasFixedSize(true);

        initializeData();

        cardTpsSaksiAdapter = new CardTpsSaksiAdapter(this, cardTpsSaksiList);
        rv_CardTpsSaksi.setAdapter(cardTpsSaksiAdapter);


        apiAdapter = new ApiAdapter();

        SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(SaksiActivity.this);
        token = settings.getString("token","");
        editor = settings.edit();

    }

    public void initializeData(){  //for recyclerview test only
        cardTpsSaksiList = new ArrayList<>();
        for (int i = 0; i <5; i++) {
            cardTpsSaksiList.add(new CardTpsSaksi(
                    "DIY, Yogyakarta, Surokartsam", "1.200", "5", "Saksi"
            ));

            cardTpsSaksiList.add(new CardTpsSaksi(
                    "DIY, Sleman, Banguntapan", "1.051", "1", "Pengawas"
            ));
        }

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SaksiActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();

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

        if (id == R.id.search_bar) {
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id  = item.getItemId();

        if(id == R.id.nav_home) {
            Intent myIntent = new Intent(SaksiActivity.this, HomeActivity.class);

            SaksiActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengamat) {
            Intent myIntent = new Intent(SaksiActivity.this, PengamatActivity.class);

            SaksiActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengawas) {
            Intent myIntent = new Intent(SaksiActivity.this, PengawasActivity.class);

            SaksiActivity.this.startActivity(myIntent);

//        } else if (id == R.id.nav_saksi) {
//            Intent myIntent = new Intent(SaksiActivity.this, SaksiActivity.class);
//
//            SaksiActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_kontestan) {

            Intent myIntent = new Intent(SaksiActivity.this, DaftarKontestanActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            SaksiActivity.this.startActivity(myIntent);

//        } else if (id == R.id.nav_group) {
//
//            Intent myIntent = new Intent(HomeActivity.this, DaftarGroupActivity.class);
//            //myIntent.putExtra("key", value); //Optional parameters
//            HomeActivity.this.startActivity(myIntent);


        } else if (id == R.id.nav_aboutMe) {

            Intent myIntent = new Intent(SaksiActivity.this, AboutMeActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            SaksiActivity.this.startActivity(myIntent);
//
//
//        } else if (id == R.id.nav_group_tentang) {
//
//            Intent myIntent = new Intent(HomeActivity.this, GroupTentang.class);
//            //myIntent.putExtra("key", value); //Optional parameters
//            HomeActivity.this.startActivity(myIntent);
//
        } else if (id == R.id.nav_logOut) {

                new AlertDialog.Builder(SaksiActivity.this)
                    .setTitle("Log out?")
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            Status status = new Status();
                            //keluar
                            apiAdapter.getRestApi().Logout(token, new Callback<Status>() {
                                @Override
                                public void success(Status status, Response response) {
                                    editor.remove("token");
                                    editor.commit();
//                                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
//
//                                  startActivity(intent);
                                    Intent intent = new Intent(SaksiActivity.this, MainActivity.class);
                                    intent.putExtra("finish", true);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                                    startActivity(intent);
                                    finish();
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
