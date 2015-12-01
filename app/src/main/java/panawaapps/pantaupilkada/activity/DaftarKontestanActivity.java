package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.CardKontestanAdapterMain;
import panawaapps.pantaupilkada.adapter.SpinnerProvincesAdapter;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.Candidate;
import panawaapps.pantaupilkada.model.CardKontestan;
import panawaapps.pantaupilkada.adapter.CardKontestanAdapter;
import panawaapps.pantaupilkada.model.Data;
import panawaapps.pantaupilkada.model.Pengamat;
import panawaapps.pantaupilkada.model.RegionOfflineData;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DaftarKontestanActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rv_daftarKontestan;
    private List<CardKontestan> cardKontestans;

    private ArrayList<String> spinners;
    private ArrayList<HashMap<String, String>> spinnerList;
    //    private ArrayList<AllCandidates> allCandidatesList;
//    private AllCandidates allCandidates;
    private Candidate candidate;
    private String province, provinceId;
    ApiAdapter apiAdapter;

    ProgressBar progressbar;
    Spinner spinner_daftarProvinsi;
    ArrayAdapter<String> adapter_spinner;
    CardKontestanAdapterMain adapterCardKontestan;


    //Variable lama
//    List<String> spinners = new ArrayList<>();
//
//    Spinner spinner_daftarProvinsi;
//    ArrayAdapter adapter_spinner;
//
//
//    //API Adapter
//    ApiAdapter apiAdapter;
//
//    //Spinner Provinsi
//    Spinner spinnerProvinsi;
//    Data provinsi;
//    List<String> dataSpinner;
//    List<Data> dataProvinsi;
//    ArrayAdapter<String> adapter;

    SharedPreferences preferences;



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

        preferences = PreferenceManager
                .getDefaultSharedPreferences(DaftarKontestanActivity.this);
        String token = preferences.getString("token", "");

        //code lama
//        spinner_daftarProvinsi = (Spinner) findViewById(R.id.spProv);
//        adapter_spinner = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinners);
//        adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_daftarProvinsi.setAdapter(adapter_spinner);
//        spinner_daftarProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                ((TextView) parent.getChildAt(0)).setTextSize(13);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//
//        rv_daftarKontestan = (RecyclerView) findViewById(R.id.rv_daftarKontestan);
//
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        rv_daftarKontestan.setLayoutManager(llm);
//        rv_daftarKontestan.setHasFixedSize(true);
//
//        initializeData();
//        initializeAdapter();

        //API Adapter
        apiAdapter = new ApiAdapter();

        progressbar = (ProgressBar) findViewById(R.id.progressBar);
        spinner_daftarProvinsi = (Spinner) findViewById(R.id.spinner_provinsi);

        spinner_daftarProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                ((TextView) parent.getChildAt(0)).setTextSize(13);
                Log.d("MyLogs", "Name - " + spinnerList.get(position).get("name"));
                Log.d("MyLogs", "Id - " + spinnerList.get(position).get("id"));
                province = spinnerList.get(position).get("name");
                provinceId = spinnerList.get(position).get("id");
//                new iinitializeData().execute(provinceId);
                parseProvince(provinceId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        rv_daftarKontestan = (RecyclerView) findViewById(R.id.rv_daftarKontestan);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv_daftarKontestan.setLayoutManager(llm);
        rv_daftarKontestan.setHasFixedSize(true);

        adapterCardKontestan = new CardKontestanAdapterMain(DaftarKontestanActivity.this, new Pengamat(), province, provinceId, false, token);
        rv_daftarKontestan.setAdapter(adapterCardKontestan);

        new grabProvinces().execute();

    }

    private void parseProvince(final String provinceId) {
        progressbar.setVisibility(View.VISIBLE);
        apiAdapter.getRestApi().getCards(provinceId, new Callback<Pengamat>() {
            @Override
            public void success(Pengamat pengamat, Response response) {
                if (pengamat.size() == 0)
                    Toast.makeText(DaftarKontestanActivity.this, "Tidak ada pemilihan di Provinsi ini", Toast.LENGTH_SHORT).show();
                else
                    adapterCardKontestan.notifyDataSetChanged(pengamat, province, provinceId);
                progressbar.setVisibility(View.GONE);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("MyLogs", "Error - " + error.getMessage());
                progressbar.setVisibility(View.GONE);
            }
        });
    }

    private class grabProvinces extends AsyncTask<Void, Void, Void> {

        private static final String provinceURL = "http://api.pantaubersama.com:80/api/locations/provinces.json?sort=asc";

        @Override
        protected Void doInBackground(Void... voids) {
            spinnerList = new ArrayList<>();
            HashMap<String, String> map = null;
            final JsonFactory jfactory = new JsonFactory();
            JsonParser jParser = null;
            try {
                jParser = jfactory.createParser(new URL(provinceURL));
                while (jParser.nextToken() != JsonToken.END_ARRAY) {
                    String fieldname = jParser.getCurrentName();
                    if ("id".equals(fieldname)) {
                        map = new HashMap<>();
                        jParser.nextToken();
                        map.put("id", jParser.getText());
                    } else if ("name".equals(fieldname)) {
                        jParser.nextToken();
                        map.put("name", jParser.getText());
                        spinnerList.add(map);
                    }
                }
            } catch (IOException | RuntimeException e) {
                e.printStackTrace();
            } finally {
                if (jParser != null) {
                    try {
                        jParser.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            spinners = new ArrayList<>();
            for (HashMap<String, String> a : spinnerList) {
                spinners.add(a.get("name"));
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
//            adapter_spinner = new ArrayAdapter<>(DaftarKontestanActivity.this, android.R.layout.simple_spinner_dropdown_item, spinners);
            adapter_spinner = new SpinnerProvincesAdapter(DaftarKontestanActivity.this, spinners);
            adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_daftarProvinsi.setAdapter(adapter_spinner);
        }
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

}
