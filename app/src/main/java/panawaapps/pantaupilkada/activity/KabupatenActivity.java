package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.KecamatanOffline;
import panawaapps.pantaupilkada.model.Region;
import panawaapps.pantaupilkada.model.RegionOfflineData;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class KabupatenActivity extends AppCompatActivity {

    //kabupaten
    ListView listView;

    List<String> kecList;

    ArrayAdapter<String> adapter;

    ApiAdapter apiAdapter;

    //kabupaten offline
    RegionOfflineData regionOfflineData;
    List<RegionOfflineData> regionOfflineDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabupaten);

        Intent kabIntent = this.getIntent();
       // String idKab = kabIntent.getExtras().getString("kabupaten");

        apiAdapter = new ApiAdapter();

        kecList = new ArrayList<>();

        listView = (ListView) findViewById(R.id.lstKabupaten);

        adapter = new ArrayAdapter<String>(this, R.layout.list_layout, R.id.label, kecList);

        //kabupaten offline
        regionOfflineDataList = new ArrayList<>();

        getRegion(); //give the parameter id that received from intent

    }

    public void getRegion(){
        apiAdapter.getRestApi().getRegion("34", new Callback<Region>() {
            @Override
            public void success(Region region, Response response) {
                listView.setAdapter(adapter);
                regionOfflineDataList = new ArrayList<RegionOfflineData>();
                if (region.getData() != null && region.getData().size() > 0) {
                    for (int i = 0; i < region.getData().size(); i++) {
                        regionOfflineData = new RegionOfflineData();
                        regionOfflineData.setId(region.getData().get(i).getId());
                        regionOfflineData.setName(region.getData().get(i).getName());
                        regionOfflineDataList.add(regionOfflineData);
                        kecList.add(region.getData().get(i).getName());

                    }
                }

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String idKab = String.valueOf(regionOfflineDataList.get(position).getId());
                        Intent kecamatannIntent = new Intent(KabupatenActivity.this, KecamatanActivity.class);
                        kecamatannIntent.putExtra("kecamatan", idKab);
                        KabupatenActivity.this.startActivity(kecamatannIntent);
                    }
                });
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
