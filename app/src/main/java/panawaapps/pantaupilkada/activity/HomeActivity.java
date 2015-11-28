package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
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
import panawaapps.pantaupilkada.adapter.CardPostHomeAdapter;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.CardPostHome;
import panawaapps.pantaupilkada.model.Home.Datum;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    List<Datum> cardPostHomes;
    RecyclerView rv_home;

    ApiAdapter apiAdapter;

    SwipeRefreshLayout swipe;
    CardPostHomeAdapter adapterCardPostHome;

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



        //untuk Konten activity
        rv_home = (RecyclerView) findViewById(R.id.rv_home);

        LinearLayoutManager layoutCardHome = new LinearLayoutManager(this);
        rv_home.setLayoutManager(layoutCardHome);
        rv_home.setHasFixedSize(true);

        cardPostHomes = new ArrayList<>();
        adapterCardPostHome= new CardPostHomeAdapter(this, cardPostHomes);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refreshCardHome);

        initializeData();
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initializeData();
            }
        });

    }

    private void initializeData(){
        apiAdapter.getRestApi().getComment(new Callback<CardPostHome>() {
            @Override
            public void success(CardPostHome cardPostHome, Response response) {
                swipe.setRefreshing(false);
                cardPostHomes.clear();
                rv_home.setAdapter(adapterCardPostHome);
                if (cardPostHome.getData().size() > 0) {
                    cardPostHomes.addAll(cardPostHome.getData());
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.iv_btnTambahPengamatan:
////                startActivity(new Intent(this, DaftarKontestanActivity.class));
//                break;
        }

    }


    //------Kebutuhan Navigation Drawer
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
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
//            Intent myIntent = new Intent(HomeActivity.this, HomeActivity.class);
//
//            HomeActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengamat) {
            Intent myIntent = new Intent(HomeActivity.this, PengamatActivity.class);

            HomeActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengawas) {
            Intent myIntent = new Intent(HomeActivity.this, PengawasActivity.class);

            HomeActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_saksi) {
            Intent myIntent = new Intent(HomeActivity.this, SaksiActivity.class);

            HomeActivity.this.startActivity(myIntent);

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
//
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
