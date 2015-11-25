package panawaapps.pantaupilkada.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.ExpandableRecyclerAdapter;
import panawaapps.pantaupilkada.adapter.TpsCardAdapter;
import panawaapps.pantaupilkada.model.ChildViewHolder;
import panawaapps.pantaupilkada.model.CardTpsParent;

import java.util.ArrayList;
import java.util.List;

public class PengawasActivity extends AppCompatActivity implements ExpandableRecyclerAdapter.ExpandCollapseListener, NavigationView.OnNavigationItemSelectedListener {

    private TpsCardAdapter adapterCardPengawas;
    private RecyclerView rvCardPengawas;

    public static Intent newIntent(Context context) {
        return new Intent(context, PengamatActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengawas);

        //Untuk Navigation Drawer
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Untuk Konten
        rvCardPengawas = (RecyclerView) findViewById(R.id.rv_cardTps);

        adapterCardPengawas = new TpsCardAdapter(this, initializeData());

        adapterCardPengawas.setExpandCollapseListener(this);

        rvCardPengawas.setAdapter(adapterCardPengawas);

        rvCardPengawas.setLayoutManager(new LinearLayoutManager(this));

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    /**
     * Load the expanded/collapsed states of the adapter back into the view when done rotating or
     * resuming the activity.
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapterCardPengawas.onRestoreInstanceState(savedInstanceState);
    }

//    @Override
//    public void onListItemExpanded(int position) {
//        String toastMessage = getString(R.string.item_expanded, position);
//        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onListItemCollapsed(int position) {
//        String toastMessage = getString(R.string.item_collapsed, position);
//        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
//    }
//
//    private void setupToolbar() {
//        setSupportActionBar(mToolbar);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
//    }

    private List<CardTpsParent> initializeData() {
        int jumlahSaksi; //utk jmlSaksi, merupakan array.size()
        List<CardTpsParent> verticalParentList = new ArrayList<>();
        List<ChildViewHolder> childItemList1 = new ArrayList<>();

        ChildViewHolder verticalChild11 = new ChildViewHolder();
        verticalChild11.setFotoCalon1(R.drawable.user);
        verticalChild11.setFotoCalon2(R.drawable.user);
        verticalChild11.setFotoCalon3(R.drawable.user);
        verticalChild11.setFotoCalon4(R.drawable.user);
        verticalChild11.setFotoCalon5(R.drawable.user);
        verticalChild11.setFotoCalon6(R.drawable.user);
        verticalChild11.setFotoWakil1(R.drawable.user);
        verticalChild11.setFotoWakil2(R.drawable.user);
        verticalChild11.setFotoWakil3(R.drawable.user);
        verticalChild11.setFotoWakil4(R.drawable.user);
        verticalChild11.setFotoWakil5(R.drawable.user);
        verticalChild11.setFotoWakil6(R.drawable.user);
        verticalChild11.setNamaCalon1("Nama Calon11 S.T. M.Eng. D.Eng");
        verticalChild11.setNamaCalon2("Nama Calon2 S.T. M.Eng. D.Eng");
        verticalChild11.setNamaCalon3("Nama Calon3 S.T. M.Eng. D.Eng");
        verticalChild11.setNamaCalon4("Nama Calon4 S.T. M.Eng. D.Eng");
        verticalChild11.setNamaCalon5("Nama Calon5 S.T. M.Eng. D.Eng");
        verticalChild11.setNamaCalon6("Nama Calon6 S.T. M.Eng. D.Eng");
        verticalChild11.setNamaWakil1("Nama Wakil1 S.T. M.Eng. D.Eng");
        verticalChild11.setNamaWakil2("Nama Wakil2 S.T. M.Eng. D.Eng");
        verticalChild11.setNamaWakil3("Nama Wakil3 S.T. M.Eng. D.Eng");
        verticalChild11.setNamaWakil4("Nama Wakil4 S.T. M.Eng. D.Eng");
        verticalChild11.setNamaWakil5("Nama Wakil5 S.T. M.Eng. D.Eng");
        verticalChild11.setNamaWakil6("Nama Wakil6 S.T. M.Eng. D.Eng");
        verticalChild11.setJmlPemilih1("12");
        verticalChild11.setJmlPemilih2("21");
        verticalChild11.setJmlPemilih3("41");
        verticalChild11.setJmlPemilih1("51");
        verticalChild11.setFotoBukti(R.drawable.camera);
        verticalChild11.setTglMulai("9 Desember 2015");
        verticalChild11.setJamMulai("09.00 WIB");
        verticalChild11.setTglSelesai("9 Desember");
        verticalChild11.setJamSelesai("16.00 WIB");
        verticalChild11.setNamaSaksi("Edityo Murti");
        verticalChild11.setNamaGrupSaksi("Panawa Group");
        verticalChild11.setJmlDownVote("30");
        verticalChild11.setJmlUpvote("50");
        childItemList1.add(verticalChild11);

        return verticalParentList;

    }

    @Override
    public void onListItemExpanded(int position) {

    }

    @Override
    public void onListItemCollapsed(int position) {

    }

    //------Kebutuhan Navigation Drawer
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PengawasActivity.this, HomeActivity.class);
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
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent myIntent = new Intent(PengawasActivity.this, HomeActivity.class);

            PengawasActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengamat) {
            Intent myIntent = new Intent(PengawasActivity.this, PengamatActivity.class);

            PengawasActivity.this.startActivity(myIntent);

//        } else if (id == R.id.nav_pengawas) {
//            Intent myIntent = new Intent(PengawasActivity.this, PengawasActivity.class);
//
//            PengawasActivity.this.startActivity(myIntent);

//        } else if (id == R.id.nav_saksi) {
//            Intent myIntent = new Intent(HomeActivity.this, SaksiActivity.class);
//
//            HomeActivity.this.startActivity(myIntent);
//
        } else if (id == R.id.nav_kontestan) {

            Intent myIntent = new Intent(PengawasActivity.this, DaftarKontestanActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            PengawasActivity.this.startActivity(myIntent);

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
}
