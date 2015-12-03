package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.CardDariKandidatAdapter;
import panawaapps.pantaupilkada.adapter.CardPostHomeAdapter;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.CardPostHome;
import panawaapps.pantaupilkada.model.Home.Datum;
import panawaapps.pantaupilkada.model.Premium;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DariKandidatActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Datum> mCardDariKandidatList;
    private RecyclerView mRecyclerView;
    private CardDariKandidatAdapter mCardDariKandidatAdapter;
    CardPostHomeAdapter cardPostHomeAdapter;

    TextView daerah;
    TextView namaCalon;
    TextView namaWakil;
    TextView dataKosong;

    String couple_id, daerahCalon, namacalon1, wakil;
    String from;
    int feedback;

    String token;


    ApiAdapter apiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dari_kandidat);

        daerah = (TextView) findViewById(R.id.tv_daerahKandidat);
        namaCalon = (TextView) findViewById(R.id.tv_namaCalon);
        namaWakil = (TextView) findViewById(R.id.tv_namaWakil);
        dataKosong = (TextView) findViewById(R.id.tv_kosong);

        Intent kandidatIntent = this.getIntent();

        //getIntent
        couple_id = kandidatIntent.getExtras().getString("couple_id");
        from = kandidatIntent.getExtras().getString("from");
        feedback = kandidatIntent.getExtras().getInt("feedback");
        daerahCalon = kandidatIntent.getExtras().getString("daerah");
        namacalon1 = kandidatIntent.getExtras().getString("calon_name");
        wakil = kandidatIntent.getExtras().getString("wakil_name");

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_dariKandidat);

        LinearLayoutManager layoutCardDariKandidat = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutCardDariKandidat);
        mRecyclerView.setHasFixedSize(true);

        findViewById(R.id.btn_tambahPostDariKandidat).setOnClickListener(this);


        mCardDariKandidatList = new ArrayList<>();
        mCardDariKandidatAdapter = new CardDariKandidatAdapter(mCardDariKandidatList);
        cardPostHomeAdapter = new CardPostHomeAdapter(this, mCardDariKandidatList, token);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        apiAdapter = new ApiAdapter();
        namaCalon.setText(namacalon1);
        namaWakil.setText(wakil);
        daerah.setText(daerahCalon);

        getDariKandidat();

        SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(DariKandidatActivity.this);
        token = settings.getString("token", "");

//        Toast.makeText(getApplicationContext(), String.valueOf(cardPostHomeAdapter.getItemCount()) , Toast.LENGTH_SHORT).show();
//        if(cardPostHomeAdapter.getItemCount() == 0){
//            dataKosong.setVisibility(View.GONE);
//        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tambahPostDariKandidat:
                    authorized();
                break;
        }
    }

    public void getDariKandidat(){
        apiAdapter.getRestApi().dariKandidat(couple_id, from, feedback, new Callback<CardPostHome>() {
            @Override
            public void success(CardPostHome cardPostHome, Response response) {
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

    public void authorized(){
        apiAdapter.getRestApi().getPremium(token, new Callback<Premium>() {
            @Override
            public void success(Premium premium, Response response) {
                    Intent intent = new Intent(DariKandidatActivity.this, DariKandidatTambahPostActivity.class);
                    intent.putExtra("coupleid", couple_id);
                    intent.putExtra("namacalon", namaCalon.getText());
                    intent.putExtra("namawakil", namaWakil.getText());
                    startActivity(intent);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "Fitur ini hanya untuk pengguna premium pasangan " + namaCalon.getText() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
