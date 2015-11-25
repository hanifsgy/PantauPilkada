package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.KelurahanOfflineData;
import panawaapps.pantaupilkada.model.SubDistricts;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class KelurahanActivity extends AppCompatActivity {

    //kelurahan

    ListView listView;
    List<String> listKelurahan;
    ArrayAdapter<String> adapter;
    ApiAdapter apiAdapter;

    //kelurahan Offline
    KelurahanOfflineData kelurahanOfflineData;
    List<KelurahanOfflineData> kelurahanOfflineDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelurahan);

        Intent kecamatanIntent = this.getIntent();
        String idKecamatan = kecamatanIntent.getExtras().getString("kelurahan");

        apiAdapter = new ApiAdapter();

        listKelurahan = new ArrayList<>();

        listView = (ListView) findViewById(R.id.lstKelurahan);

        adapter =new ArrayAdapter<String>(this, R.layout.list_layout, R.id.label, listKelurahan);

        kelurahanOfflineDataList = new ArrayList<>();
        getKelurahan(idKecamatan);
    }

    public void getKelurahan(String idKec){
        apiAdapter.getRestApi().getSubDistrict(idKec, new Callback<SubDistricts>() {
            @Override
            public void success(SubDistricts subDistricts, Response response) {
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String idKelurahan = String.valueOf(kelurahanOfflineDataList.get(position).getId());

                        Intent TPSIntent = new Intent(KelurahanActivity.this, TPSActivity.class);
                        TPSIntent.putExtra("tps", idKelurahan);
                        KelurahanActivity.this.startActivity(TPSIntent);
                    }
                });
                if (subDistricts.getData() != null && subDistricts.getData().size()>0){
                    for (int i=0; i<subDistricts.getData().size(); i++){
                        kelurahanOfflineData = new KelurahanOfflineData();
                        kelurahanOfflineData.setId(subDistricts.getData().get(i).getId());
                        kelurahanOfflineData.setName(subDistricts.getData().get(i).getName());
                        kelurahanOfflineDataList.add(kelurahanOfflineData);
                        listKelurahan.add(subDistricts.getData().get(i).getName());
                    }

                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
