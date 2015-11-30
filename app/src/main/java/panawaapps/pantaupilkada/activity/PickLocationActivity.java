package panawaapps.pantaupilkada.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.PickLocationAdapter;


public class PickLocationActivity extends AppCompatActivity {

    private TextView tvHeader;
    private PickLocationAdapter pickLocationadapter;
    private RecyclerView rv_daftarKontestan;

    private ArrayList<HashMap<String, String>> locationsList;
    private HashMap<String, String> map;
    private ArrayList<String> list;

    private static final String partURL1 = "http://api.pantaubersama.com:80/api/locations/";
    private static final String regionURL = "/regions.json?sort=asc";
    private static final String districtURL = "/districts.json?sort=asc";
    private static final String subdistrictURL = "/subdistricts.json?sort=asc";

    private int area;
    private String name, kind;
    private static final int REGION = 0;
    private static final int DISTRICT = 1;
    private static final int SUBDISTRICT = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_location);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        tvHeader = (TextView) findViewById(R.id.tv_daerahCardKontestan);

        String id = getIntent().getStringExtra("id");
        name = getIntent().getStringExtra("name");
        kind = getIntent().getStringExtra("kind");
        area = getIntent().getIntExtra("area", 0);

        tvHeader.setText(name);

        StringBuilder URL = new StringBuilder(partURL1).append(id);
        if (area == REGION) {
            URL.append(regionURL);
        } else if (area == DISTRICT) {
            URL.append(districtURL);
        } else if (area == SUBDISTRICT) {
            URL.append(subdistrictURL);
        }
        rv_daftarKontestan = (RecyclerView) findViewById(R.id.rv_daftarKontestan);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv_daftarKontestan.setLayoutManager(llm);
        rv_daftarKontestan.setHasFixedSize(true);

        new RetrieveData().execute(URL.toString());
    }

    private class RetrieveData extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... urls) {
            locationsList = new ArrayList<>();
            final JsonFactory jfactory = new JsonFactory();
            JsonParser jParser = null;
            try {
                jParser = jfactory.createParser(new URL(urls[0]));
                Log.d("MyLogs", "URL - " + urls[0]);
                while (jParser.nextToken() != JsonToken.END_ARRAY) {
                    String fieldname = jParser.getCurrentName();
                    if ("id".equals(fieldname)) {
                        map = new HashMap<>();
                        jParser.nextToken();
                        map.put("id", jParser.getText());
                    } else if ("name".equals(fieldname)) {
                        jParser.nextToken();
                        map.put("name", jParser.getText());
                        locationsList.add(map);
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
            list = new ArrayList<>();
            for (HashMap<String, String> a : locationsList) {
                list.add(a.get("name"));
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            pickLocationadapter = new PickLocationAdapter(PickLocationActivity.this, locationsList, area, name, kind);
            rv_daftarKontestan.setAdapter(pickLocationadapter);
        }
    }
}
