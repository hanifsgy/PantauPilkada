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
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.CardPostHome;
import panawaapps.pantaupilkada.model.Home.Datum;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DariKandidatActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Datum> mCardDariKandidatList;
    private RecyclerView mRecyclerView;
    private CardDariKandidatAdapter mCardDariKandidatAdapter;

    TextView daerah;
    TextView namaCalon;
    TextView namaWakil;

    String couple_id;
    String from;
    int feedback;

    String province_name;
    String region_name;
    String calon_name;
    String wakil_name;

    ApiAdapter apiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dari_kandidat);

        daerah = (TextView) findViewById(R.id.tv_daerahKandidat);
        namaCalon = (TextView) findViewById(R.id.tv_namaCalon);
        namaWakil = (TextView) findViewById(R.id.tv_namaWakil);

        Intent kandidatIntent = this.getIntent();

        //getIntent
        couple_id = kandidatIntent.getExtras().getString("couple_id");
        from = kandidatIntent.getExtras().getString("from");
        feedback = kandidatIntent.getExtras().getInt("feedback");
        province_name = kandidatIntent.getExtras().getString("province_name");

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_dariKandidat);

        LinearLayoutManager layoutCardDariKandidat = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutCardDariKandidat);
        mRecyclerView.setHasFixedSize(true);

        findViewById(R.id.btn_tambahPostDariKandidat).setOnClickListener(this);

//        for (int i=0; i<6; i++) {
//            CardDariKandidat cardDariKandidat = new CardDariKandidat.CardDariKandidatBuilder()
//                    .setJudulPost("Jargon" + String.valueOf(i))
//                    .setIsiPost("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
//                    .setNamaUser("Nama User")
//                    .build();
//
//            mCardDariKandidatList.add(cardDariKandidat);
//        }
//
//        CardDariKandidat cardDariKandidat = new CardDariKandidat.CardDariKandidatBuilder()
//                .setJudulPost("Jargon")
//                .setIsiPost("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
//                .setNamaUser("Nama User")
//                .build();
//
//        mCardDariKandidatList.add(cardDariKandidat);

        mCardDariKandidatList = new ArrayList<>();
        mCardDariKandidatAdapter = new CardDariKandidatAdapter(mCardDariKandidatList);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        apiAdapter = new ApiAdapter();

        getDariKandidat(couple_id, "candidate", 1);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tambahPostDariKandidat:
                Intent intent = new Intent(DariKandidatActivity.this, DariKandidatTambahPostActivity.class);
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
                mCardDariKandidatList.clear();
                mRecyclerView.setAdapter(mCardDariKandidatAdapter);

//                if (cardPostHome.getData().size() > 0) {
//                    namaCalon.setText(cardPostHome.getData().get(0).getComment().getCoupleName().getCouple().getCalonName());
//                    namaWakil.setText(cardPostHome.getData().get(0).getComment().getCoupleName().getCouple().getWakilName());
//                    daerah.setText(cardPostHome.getData().get(0).getComment().getCoupleName().getCouple().getProvinceName() + ", " +
//                            cardPostHome.getData().get(0).getComment().getCoupleName().getCouple().getRegionName());
//                    mCardDariKandidatList.addAll(cardPostHome.getData());
//                }

                namaCalon.setText(cardPostHome.getData().get(0).getComment().getCoupleName().getCouple().getCalonName());
                namaWakil.setText(cardPostHome.getData().get(0).getComment().getCoupleName().getCouple().getWakilName());
                daerah.setText(cardPostHome.getData().get(0).getComment().getCoupleName().getCouple().getProvinceName() + ", " +
                        cardPostHome.getData().get(0).getComment().getCoupleName().getCouple().getRegionName());
                mCardDariKandidatList.addAll(cardPostHome.getData());

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
