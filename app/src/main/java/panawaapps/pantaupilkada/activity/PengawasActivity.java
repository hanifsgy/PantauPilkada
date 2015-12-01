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
import android.widget.ProgressBar;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.ExpandableRecyclerAdapter;
import panawaapps.pantaupilkada.adapter.TpsCardAdapter;
import panawaapps.pantaupilkada.model.CardTpsChild;
import panawaapps.pantaupilkada.model.ChildViewHolder;
import panawaapps.pantaupilkada.model.CardTpsParent;

import java.util.ArrayList;
import java.util.List;

public class PengawasActivity extends AppCompatActivity implements ExpandableRecyclerAdapter.ExpandCollapseListener, NavigationView.OnNavigationItemSelectedListener {

    private TpsCardAdapter adapterCardPengawas;
    private RecyclerView rvCardPengawas;

    private ProgressBar progressBar;

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
        List<CardTpsParent> cardTpsParents = new ArrayList<>();
        List<CardTpsChild> cardTpsChildren1 = new ArrayList<>();


        return cardTpsParents;

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

        } else if (id == R.id.nav_saksi) {
            Intent myIntent = new Intent(PengawasActivity.this, SaksiActivity.class);

            PengawasActivity.this.startActivity(myIntent);

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
