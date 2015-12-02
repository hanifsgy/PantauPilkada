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
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.CardAdapter;
import panawaapps.pantaupilkada.adapter.CardKontestanAdapterMain;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.controller.ControllerPengamat;
import panawaapps.pantaupilkada.model.Card;
import panawaapps.pantaupilkada.model.Pengamat;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PengamatActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, ControllerPengamat.ContestCallbackListener {

    private List<Card> cardList = new ArrayList<>();
//    private List<Info> infos;
    private RecyclerView rv_cardKontestan;
//    private RecyclerView rv2;
    private ImageView bTambahPengamatan;
    private RelativeLayout layout_infoCard;

    private CardKontestanAdapterMain adapterCardKontestan;

    //utk fetching json
    private ApiAdapter apiAdapter;

    private SwipeRefreshLayout mSwipe;
    private ProgressBar progressBar;

    SharedPreferences settings;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengamat);

        settings = PreferenceManager
                .getDefaultSharedPreferences(PengamatActivity.this);
        token = settings.getString("token", "");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        apiAdapter = new ApiAdapter();
        //untuk swipeToRefresh
        configViews();
        startFetching();

    }

    private void configViews() {
        rv_cardKontestan = (RecyclerView) findViewById(R.id.rv_cardKontestan);
        mSwipe = (SwipeRefreshLayout) this.findViewById(R.id.swipe);
//        rv2 = (RecyclerView) findViewById(R.id.rvContestCard);

        rv_cardKontestan.setHasFixedSize(true);
//        LinearLayoutManager layoutCardKontestan = new LinearLayoutManager(this);
        rv_cardKontestan.setLayoutManager(new LinearLayoutManager(PengamatActivity.this));
//        rv_cardKontestan.setRecycledViewPool(new RecyclerView.RecycledViewPool());

        bTambahPengamatan = (ImageView) findViewById(R.id.iv_btnTambahPengamatan);
        bTambahPengamatan.setOnClickListener(this);

//        adapterCardKontestan = new CardKontestanAdapterMain(PengamatActivity.this, new Pengamat(), true, token);
        adapterCardKontestan = new CardKontestanAdapterMain(PengamatActivity.this, new Pengamat(), true, token);
        rv_cardKontestan.setAdapter(adapterCardKontestan);

        layout_infoCard = (RelativeLayout) findViewById(R.id.layout_infoCard);
        layout_infoCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(PengamatActivity.this)
                        .setTitle("Hapus Info?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                layout_infoCard.setVisibility(View.GONE);
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
                return false;
            }
        });

//        LinearLayoutManager layoutInfo = new LinearLayoutManager(this);
//        rv2.setLayoutManager(layoutContest);

        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                startFetching();
            }
        });
    }

    private void startFetching() {

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        apiAdapter.getRestApi().getPengamat(token, new Callback<Pengamat>() {
            @Override
            public void success(Pengamat pengamat, Response response) {
                if (pengamat.size() != 0){
                    mSwipe.setRefreshing(false);
                    progressBar.setVisibility(View.GONE);
                    adapterCardKontestan.notifyDataSetChanged(pengamat);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_btnTambahPengamatan:
                startActivity(new Intent(this, DaftarKontestanActivity.class));
                break;
        }

    }

    //------Kebutuhan Navigation Drawer
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PengamatActivity.this, HomeActivity.class);
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
            Intent myIntent = new Intent(PengamatActivity.this, HomeActivity.class);

            PengamatActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengamat) {
//            Intent myIntent = new Intent(PengamatActivity.this, PengamatActivity.class);
//
//            PengamatActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengawas) {
            Intent myIntent = new Intent(PengamatActivity.this, PengawasActivity.class);

            PengamatActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_saksi) {
            Intent myIntent = new Intent(PengamatActivity.this, SaksiActivity.class);

            PengamatActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_kontestan) {

            Intent myIntent = new Intent(PengamatActivity.this, DaftarKontestanActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            PengamatActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_aboutMe) {

            Intent myIntent = new Intent(PengamatActivity.this, AboutMeActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            PengamatActivity.this.startActivity(myIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFetchStart() {

    }

    @Override
    public void onFetchProgress(Card card) {
//        mCardAdapter.addCard(card);
    }

    @Override
    public void onFetchProgress(List<Card> cardList) {

    }

    @Override
    public void onFetchComplete() {
        mSwipe.setRefreshing(false);
    }

    @Override
    public void onFetchFailed() {

    }
}
