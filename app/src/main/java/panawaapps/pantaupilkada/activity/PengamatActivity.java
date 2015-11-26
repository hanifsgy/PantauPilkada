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
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.CardAdapter;
import panawaapps.pantaupilkada.controller.ControllerPengamat;
import panawaapps.pantaupilkada.model.Card;

public class PengamatActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, ControllerPengamat.ContestCallbackListener {

    private List<Card> cardList = new ArrayList<>();
//    private List<Info> infos;
    private RecyclerView rv_cardKontestan;
//    private RecyclerView rv2;
    private ImageView bTambahPengamatan;

    //utk fetching json
    private ControllerPengamat mController;
    private CardAdapter mCardAdapter;

    private SwipeRefreshLayout mSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengamat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mController = new ControllerPengamat(PengamatActivity.this);

        //untuk swipeToRefresh
        configViews();
//        mController.startFetching();


//        rv2.setHasFixedSize(true);


//        initializeData();
//        initializeAdapter();

    }

    private void configViews() {
        rv_cardKontestan = (RecyclerView) findViewById(R.id.rv_cardKontestan);
        mSwipe = (SwipeRefreshLayout) this.findViewById(R.id.swipe);
//        rv2 = (RecyclerView) findViewById(R.id.rvContestCard);

        rv_cardKontestan.setHasFixedSize(true);
//        LinearLayoutManager layoutCardKontestan = new LinearLayoutManager(this);
        rv_cardKontestan.setLayoutManager(new LinearLayoutManager(PengamatActivity.this));
        rv_cardKontestan.setRecycledViewPool(new RecyclerView.RecycledViewPool());

        bTambahPengamatan = (ImageView) findViewById(R.id.iv_btnTambahPengamatan);
        bTambahPengamatan.setOnClickListener(this);

//        LinearLayoutManager layoutInfo = new LinearLayoutManager(this);
//        rv2.setLayoutManager(layoutContest);

        mController.startFetching();

        mCardAdapter = new CardAdapter(cardList);
        rv_cardKontestan.setAdapter(mCardAdapter);

        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                mController.startFetching();
            }
        });

        addCard();
    }

    private void addCard(){
//        for (int i = 0; i <9; i++){
//            Card card = new Card.Builder()
////                    .setRegionId(12)
////                    .setCalonId(12)
////                    .setWakilId(123)
//                    .setRegioName("asdas")
//                    .setCalonName("sadadsad")
//                    .setWakilName("asdas")
////                    .setCoupleId("123321")
////                    .setKind("sdads")
//                    .build();
//
//            CardAdapter adapter = new CardAdapter(cardList);
//            adapter.addCard(card);
//        }
    }


    private void initializeData(){
//        infos = new ArrayList<>();
//        infos.add(new Info("Tambahakan pemilihan yang ingin anda amati, pemilihan yang ingin anda pilih akan muncul di halaman ini untuk bisa diamati secara langsung"));
//        infos.add(new Info("ini info kedua"));
//        infos.add(new Info("ini info ketiga"));

//        cardKontestans = new ArrayList<>();
//        cardKontestans.add(new CardKontestan(
//                "Bupati, Sleman, Yogyakarta", "123422",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "12",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "1",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "3",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "4",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "66",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "123",
//                "2000 (49%)", "300 (13% TPS)", "9 (2% TPS)", "9 Desember 2015"));
//        cardKontestans.add(new CardKontestan(
//                "Bupati, Bantul, Yogyakarta", "23222",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "2",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "5",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "6",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "12",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "6",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "13",
//                "2000 (49%)", "300 (13% TPS)", "9 (2% TPS)", "9 Desember 2015"));
//        cardKontestans.add(new CardKontestan(
//                "Bupati, Kulon Progo, Yogyakarta", "32322",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "13",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "5",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "5",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "13",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "68",
//                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "51",
//                "2000 (49%)", "300 (13% TPS)", "9 (2% TPS)", "9 Desember 2015"));
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

//        } else if (id == R.id.nav_group) {
//
//            Intent myIntent = new Intent(HomeActivity.this, DaftarGroupActivity.class);
//            //myIntent.putExtra("key", value); //Optional parameters
//            HomeActivity.this.startActivity(myIntent);


//        } else if (id == R.id.nav_aboutMe) {
//
//            Intent myIntent = new Intent(HomeActivity.this, AboutMe.class);
//            //myIntent.putExtra("key", value); //Optional parameters
//            HomeActivity.this.startActivity(myIntent);
//
//
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

    @Override
    public void onFetchStart() {

    }

    @Override
    public void onFetchProgress(Card card) {
        mCardAdapter.addCard(card);
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
