package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.TPSAdapter;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.TPS.Datum;
import panawaapps.pantaupilkada.model.TPS.TPS;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TPSActivity extends AppCompatActivity {

    ApiAdapter apiAdapter;

    List<Datum> tpsList;
    TPSAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tps);

        Intent kelurahanIntent = this.getIntent();
        String idKelurahan = kelurahanIntent.getExtras().getString("tps");
        String kind = kelurahanIntent.getExtras().getString("kind");
        Log.d("MyLogs", "Kind - " + kind);

        tpsList = new ArrayList<>();

        apiAdapter = new ApiAdapter();

        adapter = new TPSAdapter(this, tpsList);
        final TextView tvDaerahCard = (TextView) findViewById(R.id.tv_daerahCardKontestan);
        recyclerView = (RecyclerView) findViewById(R.id.tpsList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        apiAdapter.getRestApi().getTPS(idKelurahan, kind.toUpperCase(), new Callback<TPS>() {
            @Override
            public void success(TPS tp, Response response) {
                final Datum tps = tp.getData().get(0);
                tvDaerahCard.setText(tps.getKind_label() + ", " + tps.getProvinceName() + ", " + tps.getRegionName() + ", " + tps.getDistrictName() + ", " + tps.getSubdistrictName());
                recyclerView.setAdapter(adapter);
                if (tp.getData().size() > 0) {
                    List<Datum> list = tp.getData();
                    Collections.sort(list, new Comparator<Datum>() {
                        @Override
                        public int compare(Datum x, Datum y) {
                            return x.getId().compareTo(y.getId());
                        }
                    });
                    tpsList.addAll(list);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }
}
