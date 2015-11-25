package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
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

        tpsList = new ArrayList<Datum>();

        apiAdapter = new ApiAdapter();

        adapter = new TPSAdapter(tpsList);

        recyclerView = (RecyclerView) findViewById(R.id.tpsList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        apiAdapter.getRestApi().getTPS(idKelurahan, new Callback<TPS>() {
            @Override
            public void success(TPS tps, Response response) {
                recyclerView.setAdapter(adapter);
                if (tps.getData().size() > 0) {
                    tpsList.addAll(tps.getData());
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }
}
