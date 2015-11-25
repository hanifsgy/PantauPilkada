package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import panawaapps.pantaupilkada.api.ApiAdapter;

import java.util.ArrayList;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.model.District;
import panawaapps.pantaupilkada.model.KecamatanOffline;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class KecamatanActivity extends AppCompatActivity {

    //kecamatan
    ListView listView;

    List<String> kelList;

    ArrayAdapter<String> adapter;

    ApiAdapter apiAdapter;

    //kecamatan offline
    KecamatanOffline kecamatanOffline;
    List<KecamatanOffline> kecamatanOfflineList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kecamatan);

        Intent kabIntent = this.getIntent();
        String idKab = kabIntent.getExtras().getString("kecamatan");

        apiAdapter = new ApiAdapter();

        kelList = new ArrayList<>();

        listView = (ListView) findViewById(R.id.lstKecamatan);
        adapter = new ArrayAdapter<String>(this, R.layout.list_layout, R.id.label, kelList);

        //kecamatan offline
        kecamatanOfflineList = new ArrayList<>();

        getDistricts(idKab);

    }

    public void getDistricts(String idKabupaten){
        apiAdapter.getRestApi().getDistrict(idKabupaten, new Callback<District>() {
            @Override
            public void success(District district, Response response) {
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String idKecamatan = String.valueOf(kecamatanOfflineList.get(position).getId());
                        Intent kelurahanIntent = new Intent(KecamatanActivity.this, KelurahanActivity.class);
                        kelurahanIntent.putExtra("kelurahan", idKecamatan);
                        KecamatanActivity.this.startActivity(kelurahanIntent);
                    }
                });
                if (district.getData() != null && district.getData().size() > 0){
                    for (int i = 0; i<district.getData().size(); i++){
                        kecamatanOffline = new KecamatanOffline();
                        kecamatanOffline.setId(district.getData().get(i).getId());
                        kecamatanOffline.setName(district.getData().get(i).getName());
                        kecamatanOfflineList.add(kecamatanOffline);
                        kelList.add(district.getData().get(i).getName());
                    }
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


}
