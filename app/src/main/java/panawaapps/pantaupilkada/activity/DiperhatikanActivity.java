package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.CardDariKandidatAdapter;
import panawaapps.pantaupilkada.adapter.CardDiperhatikanAdapter;
import panawaapps.pantaupilkada.adapter.CardPostHomeAdapter;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.CardPostHome;
import panawaapps.pantaupilkada.model.Home.Datum;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DiperhatikanActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Datum> mCardDariKandidatList;
    private RecyclerView mRecyclerView;
    private CardDiperhatikanAdapter mCardDariKandidatAdapter;
    CardPostHomeAdapter cardPostHomeAdapter;

    TextView daerah;
    TextView namaCalon;
    TextView namaWakil;

    String couple_id, daerahCalon, namacalon1, wakil;
    String from;
    int feedback;

    ApiAdapter apiAdapter;

    SwipeRefreshLayout swipe;

    String token;
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diperhatikan);

        daerah = (TextView) findViewById(R.id.tv_daerahKandidat);
        namaCalon = (TextView) findViewById(R.id.tv_namaCalon);
        namaWakil = (TextView) findViewById(R.id.tv_namaWakil);

        SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(DiperhatikanActivity.this);
        token = settings.getString("token", "");
        editor = settings.edit();

        Intent kandidatIntent = this.getIntent();

        //getIntent
        couple_id = kandidatIntent.getExtras().getString("couple_id");
        from = kandidatIntent.getExtras().getString("from");
        feedback = kandidatIntent.getExtras().getInt("feedback");
        daerahCalon = kandidatIntent.getExtras().getString("daerah");
        namacalon1 = kandidatIntent.getExtras().getString("calon_name");
        wakil = kandidatIntent.getExtras().getString("wakil_name");


        mRecyclerView = (RecyclerView) findViewById(R.id.rv_diPerhatikan);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refreshCardHome);

        LinearLayoutManager layoutCardDariKandidat = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutCardDariKandidat);
        mRecyclerView.setHasFixedSize(true);

        findViewById(R.id.btn_tambahPostDiperhatikan).setOnClickListener(this);

        mCardDariKandidatList = new ArrayList<>();
        mCardDariKandidatAdapter = new CardDiperhatikanAdapter(mCardDariKandidatList);
        cardPostHomeAdapter = new CardPostHomeAdapter(this, mCardDariKandidatList, token);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        namaCalon.setText(namacalon1);
        namaWakil.setText(wakil);
        daerah.setText(daerahCalon);

        apiAdapter = new ApiAdapter();

        getDariKandidat(couple_id, "voter", 0);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDariKandidat(couple_id, "voter", 0);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tambahPostDiperhatikan:
                Intent intent = new Intent(DiperhatikanActivity.this, DiperhatikanTambahPostActivity.class);
                intent.putExtra("coupleid", couple_id);
                intent.putExtra("namacalon", namaCalon.getText());
                intent.putExtra("namawakil", namaWakil.getText());
                startActivity(intent);
                break;
        }
    }

    public void getDariKandidat(String couple_id, String from, int feedback){
        apiAdapter.getRestApi().dariKandidat(couple_id, from, feedback, new Callback<CardPostHome>() {
            @Override
            public void success(CardPostHome cardPostHome, Response response) {
                swipe.setRefreshing(false);
                mCardDariKandidatList.clear();
                mRecyclerView.setAdapter(cardPostHomeAdapter);

                if (cardPostHome.getData().size() > 0) {
                    mCardDariKandidatList.addAll(cardPostHome.getData());
                }

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
