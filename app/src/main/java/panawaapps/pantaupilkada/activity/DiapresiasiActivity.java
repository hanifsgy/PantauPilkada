package panawaapps.pantaupilkada.activity;

import android.content.Intent;
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
import panawaapps.pantaupilkada.adapter.CardDiapresiasiAdapter;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.CardPostHome;
import panawaapps.pantaupilkada.model.Home.Datum;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DiapresiasiActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Datum> mCardDariKandidatList;
    private RecyclerView mRecyclerView;
    private CardDiapresiasiAdapter mCardDariKandidatAdapter;

    TextView daerah;
    TextView namaCalon;
    TextView namaWakil;

    String couple_id;
    String from;
    int feedback;

    ApiAdapter apiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diapresiasi);

        daerah = (TextView) findViewById(R.id.tv_daerahKandidat);
        namaCalon = (TextView) findViewById(R.id.tv_namaCalon);
        namaWakil = (TextView) findViewById(R.id.tv_namaWakil);

        Intent kandidatIntent = this.getIntent();

        //getIntent
        couple_id = kandidatIntent.getExtras().getString("couple_id");
        from = kandidatIntent.getExtras().getString("from");
        feedback = kandidatIntent.getExtras().getInt("feedback");

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_diApresiasi);

        LinearLayoutManager layoutCardDariKandidat = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutCardDariKandidat);
        mRecyclerView.setHasFixedSize(true);

        findViewById(R.id.btn_tambahPostDiapresiasi).setOnClickListener(this);

        mCardDariKandidatList = new ArrayList<>();
        mCardDariKandidatAdapter = new CardDiapresiasiAdapter(mCardDariKandidatList);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        apiAdapter = new ApiAdapter();

        getDariKandidat(couple_id, "voter", 1);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tambahPostDiapresiasi:
                startActivity(new Intent(this, DiapresiasiTambahPostActivity.class));
                break;
        }
    }

    public void getDariKandidat(String couple_id, String from, int feedback) {
        apiAdapter.getRestApi().dariKandidat(couple_id, from, feedback, new Callback<CardPostHome>() {
            @Override
            public void success(CardPostHome cardPostHome, Response response) {
                mCardDariKandidatList.clear();
                mRecyclerView.setAdapter(mCardDariKandidatAdapter);


                if (cardPostHome.getData().size() > 0) {
                    namaCalon.setText(cardPostHome.getData().get(0).getComment().getCoupleName().getCouple().getCalonName());
                    namaWakil.setText(cardPostHome.getData().get(0).getComment().getCoupleName().getCouple().getWakilName());
                    daerah.setText(cardPostHome.getData().get(0).getComment().getCoupleName().getCouple().getProvinceName() + ", " +
                            cardPostHome.getData().get(0).getComment().getCoupleName().getCouple().getRegionName());
                    mCardDariKandidatList.addAll(cardPostHome.getData());
                }


            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
