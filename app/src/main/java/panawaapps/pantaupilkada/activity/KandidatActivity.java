package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.Kandidat.KandidatPojo;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class KandidatActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvDaerahKandidat;
    TextView tvNamaCalon;
    TextView tvNamaWakil;
    TextView tvJmlApresiasi;
    TextView tvJumlahDiperhatikan;
    TextView tvJmlPostKandidat;

    LinearLayout btn_dariKandidat;
    LinearLayout btn_diApresiasi;
    LinearLayout btn_diPerhatikan;

    ApiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kandidat);

        tvDaerahKandidat = (TextView) findViewById(R.id.tv_daerahKandidat);
        tvNamaCalon = (TextView) findViewById(R.id.tv_namaCalon);
        tvNamaWakil = (TextView) findViewById(R.id.namaWakil);
        tvJmlApresiasi = (TextView) findViewById(R.id.tv_jmlPostDiapresiasi);
        tvJumlahDiperhatikan = (TextView) findViewById(R.id.tv_jmlPostDiperhatikan);
        tvJmlPostKandidat = (TextView) findViewById(R.id.tv_jmlPostDariKandidat);

        btn_dariKandidat = (LinearLayout) findViewById(R.id.btn_dariKandidat);
        btn_dariKandidat.setOnClickListener(this);
        btn_diApresiasi = (LinearLayout) findViewById(R.id.btn_diApresiasi);
        btn_diPerhatikan = (LinearLayout) findViewById(R.id.btn_diPerhatikan);

        adapter = new ApiAdapter();
        adapter.getRestApi().getKandidat("9f958cca-4fdb-4eed-86ad-4181d7a341c3", new Callback<KandidatPojo>() {
            @Override
            public void success(KandidatPojo kandidatPojo, Response response) {
//                Toast.makeText(getApplicationContext(), kandidatPojo.getData().getCalonName(), Toast.LENGTH_SHORT).show();
                tvDaerahKandidat.setText(kandidatPojo.getData().getRegionName() + ", " + kandidatPojo.getData().provinceName);
                tvNamaCalon.setText(kandidatPojo.getData().getCalonName());
                tvNamaWakil.setText(kandidatPojo.getData().getWakilName());
                tvJmlApresiasi.setText(String.valueOf(kandidatPojo.getData().getFromVoterApresiasi()));
                tvJumlahDiperhatikan.setText(String.valueOf(kandidatPojo.getData().getFromVoterPerhatikan()));
                tvJmlPostKandidat.setText(String.valueOf(kandidatPojo.getData().getFromVoter()));
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dariKandidat:
                startActivity(new Intent(this, DariKandidatActivity.class));
                break;
        }
    }
}
