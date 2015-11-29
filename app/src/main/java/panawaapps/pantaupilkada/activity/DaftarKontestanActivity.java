package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.CardKontestan;
import panawaapps.pantaupilkada.adapter.CardKontestanAdapter;
import panawaapps.pantaupilkada.model.Data;
import panawaapps.pantaupilkada.model.RegionOfflineData;


import java.util.ArrayList;
import java.util.List;

public class DaftarKontestanActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rv_daftarKontestan;
    private List<CardKontestan> cardKontestans;

    List<String> spinners = new ArrayList<>();

    Spinner spinner_daftarProvinsi;
    ArrayAdapter adapter_spinner;


    //API Adapter
    ApiAdapter apiAdapter;

    //Spinner Provinsi
    Spinner spinnerProvinsi;
    Data provinsi;
    List<String> dataSpinner;
    List<Data> dataProvinsi;
    ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_kontestan);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        spinner_daftarProvinsi = (Spinner) findViewById(R.id.spProv);
        adapter_spinner = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinners);
        adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_daftarProvinsi.setAdapter(adapter_spinner);
        spinner_daftarProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextSize(13);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        rv_daftarKontestan = (RecyclerView) findViewById(R.id.rv_daftarKontestan);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv_daftarKontestan.setLayoutManager(llm);
        rv_daftarKontestan.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

        //API Adapter
        apiAdapter = new ApiAdapter();


        //provinsi
        dataSpinner = new ArrayList<>();
        addProvince();

    }

    private void initializeData(){
        cardKontestans = new ArrayList<>();
        cardKontestans.add(new CardKontestan(
                "Bupati, Sleman, Yogyakarta", "123422",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "12",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "1",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "3",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "4",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "66",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "123",
                "2000 (49%)", "300 (13% TPS)", "9 (2% TPS)", "9 Desember 2015"));
        cardKontestans.add(new CardKontestan(
                "Bupati, Bantul, Yogyakarta", "23222",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "2",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "5",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "6",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "12",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "6",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "13",
                "2000 (49%)", "300 (13% TPS)", "9 (2% TPS)", "9 Desember 2015"));
        cardKontestans.add(new CardKontestan(
                "Bupati, Kulon Progo, Yogyakarta", "32322",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "13",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "5",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "5",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "13",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "68",
                R.drawable.user, R.drawable.user, "Nama Calon S.T. M.Eng. D.Eng", "Nama Wakil S.T. M.Eng. D.Eng", "51",
                "2000 (49%)", "300 (13% TPS)", "9 (2% TPS)", "9 Desember 2015"));
    }

    private void initializeAdapter(){
        CardKontestanAdapter adapterCardKontestan = new CardKontestanAdapter(this, cardKontestans);
        rv_daftarKontestan.setAdapter(adapterCardKontestan);

    }

    //------Kebutuhan Navigation Drawer
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DaftarKontestanActivity.this, HomeActivity.class);
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
            Intent myIntent = new Intent(DaftarKontestanActivity.this, HomeActivity.class);

            DaftarKontestanActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengamat) {
            Intent myIntent = new Intent(DaftarKontestanActivity.this, PengamatActivity.class);

            DaftarKontestanActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengawas) {
            Intent myIntent = new Intent(DaftarKontestanActivity.this, PengawasActivity.class);

            DaftarKontestanActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_saksi) {
            Intent myIntent = new Intent(DaftarKontestanActivity.this, SaksiActivity.class);

            DaftarKontestanActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_kontestan) {

            Intent myIntent = new Intent(DaftarKontestanActivity.this, DaftarKontestanActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            DaftarKontestanActivity.this.startActivity(myIntent);

//        } else if (id == R.id.nav_group) {
//
//            Intent myIntent = new Intent(HomeActivity.this, DaftarGroupActivity.class);
//            //myIntent.putExtra("key", value); //Optional parameters
//            HomeActivity.this.startActivity(myIntent);


        } else if (id == R.id.nav_aboutMe) {

            Intent myIntent = new Intent(DaftarKontestanActivity.this, AboutMeActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            DaftarKontestanActivity.this.startActivity(myIntent);
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

    public void addProvince(){
        dataProvinsi = new ArrayList<>();

        provinsi = new Data();
        provinsi.setId(11);
        provinsi.setName("ACEH");
        dataProvinsi.add(provinsi);
        dataSpinner.add("ACEH");

        provinsi = new Data();
        provinsi.setId(51);
        provinsi.setName("BALI");
        dataProvinsi.add(provinsi);
        dataSpinner.add("BALI");

        provinsi = new Data();
        provinsi.setId(36);
        provinsi.setName("BANTEN");
        dataProvinsi.add(provinsi);
        dataSpinner.add("BANTEN");

        provinsi = new Data();
        provinsi.setId(17);
        provinsi.setName("BENGKULU");
        dataProvinsi.add(provinsi);
        dataSpinner.add("BENGKULU");

        provinsi = new Data();
        provinsi.setId(34);
        provinsi.setName("DAERAH ISTIMEWA YOGYAKARTA");
        dataProvinsi.add(provinsi);
        dataSpinner.add("DAERAH ISTIMEWA YOGYAKARTA");

        provinsi = new Data();
        provinsi.setId(31);
        provinsi.setName("DKI JAKARTA");
        dataProvinsi.add(provinsi);
        dataSpinner.add("DKI JAKARTA");

        provinsi = new Data();
        provinsi.setId(75);
        provinsi.setName("GORONTALO");
        dataProvinsi.add(provinsi);
        dataSpinner.add("GORONTALO");

        provinsi = new Data();
        provinsi.setId(15);
        provinsi.setName("JAMBI");
        dataProvinsi.add(provinsi);
        dataSpinner.add("JAMBI");

        provinsi = new Data();
        provinsi.setId(32);
        provinsi.setName("JAWA BARAT");
        dataProvinsi.add(provinsi);
        dataSpinner.add("JAWA BARAT");

        provinsi = new Data();
        provinsi.setId(33);
        provinsi.setName("JAWA TENGAH");
        dataProvinsi.add(provinsi);
        dataSpinner.add("JAWA TENGAH");

        provinsi = new Data();
        provinsi.setId(35);
        provinsi.setName("JAWA TIMUR");
        dataProvinsi.add(provinsi);
        dataSpinner.add("JAWA TIMUR");

        provinsi = new Data();
        provinsi.setId(61);
        provinsi.setName("KALIMANTAN BARAT");
        dataProvinsi.add(provinsi);
        dataSpinner.add("KALIMANTAN BARAT");

        provinsi = new Data();
        provinsi.setId(63);
        provinsi.setName("KALIMANTAN SELATAN");
        dataProvinsi.add(provinsi);
        dataSpinner.add("KALIMANTAN SELATAN");

        provinsi = new Data();
        provinsi.setId(62);
        provinsi.setName("KALIMANTAN TENGAH");
        dataProvinsi.add(provinsi);
        dataSpinner.add("KALIMANTAN TENGAH");

        provinsi = new Data();
        provinsi.setId(64);
        provinsi.setName("KALIMANTAN TIMUR");
        dataProvinsi.add(provinsi);
        dataSpinner.add("KALIMANTAN TIMUR");

        provinsi = new Data();
        provinsi.setId(19);
        provinsi.setName("KALIMANTAN UTARA");
        dataProvinsi.add(provinsi);
        dataSpinner.add("KALIMANTAN UTARA");

        provinsi = new Data();
        provinsi.setId(21);
        provinsi.setName("KEPULAUAN RIAU");
        dataProvinsi.add(provinsi);
        dataSpinner.add("KEPULAUAN RIAU");

        provinsi = new Data();
        provinsi.setId(18);
        provinsi.setName("LAMPUNG");
        dataProvinsi.add(provinsi);
        dataSpinner.add("LAMPUNG");

        provinsi = new Data();
        provinsi.setId(81);
        provinsi.setName("MALUKU");
        dataProvinsi.add(provinsi);
        dataSpinner.add("MALUKU");

        provinsi = new Data();
        provinsi.setId(82);
        provinsi.setName("MALUKU UTARA");
        dataProvinsi.add(provinsi);
        dataSpinner.add("MALUKU UTARA");

        provinsi = new Data();
        provinsi.setId(52);
        provinsi.setName("NUSA TENGGARA BARAT");
        dataProvinsi.add(provinsi);
        dataSpinner.add("NUSA TENGGARA BARAT");

        provinsi = new Data();
        provinsi.setId(53);
        provinsi.setName("NUSA TENGGARA TIMUR");
        dataProvinsi.add(provinsi);
        dataSpinner.add("MUSA TENGGARA TIMUR");

        provinsi = new Data();
        provinsi.setId(91);
        provinsi.setName("P A P U A");
        dataProvinsi.add(provinsi);
        dataSpinner.add("P A P U A");

        provinsi = new Data();
        provinsi.setId(92);
        provinsi.setName("PAPUA BARAT");
        dataProvinsi.add(provinsi);
        dataSpinner.add("PAPUA BARAT");

        provinsi = new Data();
        provinsi.setId(14);
        provinsi.setName("RIAU");
        dataProvinsi.add(provinsi);
        dataSpinner.add("RIAU");

        provinsi = new Data();
        provinsi.setId(76);
        provinsi.setName("SULAWESI BARAT");
        dataProvinsi.add(provinsi);
        dataSpinner.add("SULAWESI BARAT");

        provinsi = new Data();
        provinsi.setId(73);
        provinsi.setName("SULAWESI SELATAN");
        dataProvinsi.add(provinsi);
        dataSpinner.add("SULAWESI SELATAN");

        provinsi = new Data();
        provinsi.setId(72);
        provinsi.setName("SULAWESI TENGAH");
        dataProvinsi.add(provinsi);
        dataSpinner.add("SULAWESI TENGAH");

        provinsi = new Data();
        provinsi.setId(74);
        provinsi.setName("SULAWESI TENGGARA");
        dataProvinsi.add(provinsi);
        dataSpinner.add("SULAWESI TENGGARA");

        provinsi = new Data();
        provinsi.setId(71);
        provinsi.setName("SULAWESI UTARA");
        dataProvinsi.add(provinsi);
        dataSpinner.add("SULAWESI UTARA");

        provinsi = new Data();
        provinsi.setId(13);
        provinsi.setName("SUMATRA BARAT");
        dataProvinsi.add(provinsi);
        dataSpinner.add("SUMATRA BARAT");

        provinsi = new Data();
        provinsi.setId(16);
        provinsi.setName("SUMATRA SELATAN");
        dataProvinsi.add(provinsi);
        dataSpinner.add("SUMATRA SELATAN");

        provinsi = new Data();
        provinsi.setId(12);
        provinsi.setName("SUMATRA UTARA");
        dataProvinsi.add(provinsi);
        dataSpinner.add("SUMATRA UTARA");

        initSpinner();
    }

    private void initSpinner() {
        spinnerProvinsi = (Spinner) findViewById(R.id.spProv);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dataSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProvinsi.setAdapter(adapter);
        spinnerProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String idProvince = String.valueOf(dataProvinsi.get(position).getId());
                Toast.makeText(getApplicationContext(), idProvince, Toast.LENGTH_LONG).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
