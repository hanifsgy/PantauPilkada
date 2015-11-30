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

    String cpid;

    String province_name;
    String region_name;
    String calon_name;
    String wakil_name;

    ApiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kandidat);

        Intent kandidatIntent = this.getIntent();
        final String couple_id = kandidatIntent.getExtras().getString("couple_id");

        cpid = couple_id;

        tvDaerahKandidat = (TextView) findViewById(R.id.tv_daerahKandidat);
        tvNamaCalon = (TextView) findViewById(R.id.tv_namaCalon);
        tvNamaWakil = (TextView) findViewById(R.id.namaWakil);
        tvJmlApresiasi = (TextView) findViewById(R.id.tv_jmlPostDiapresiasi);
        tvJumlahDiperhatikan = (TextView) findViewById(R.id.tv_jmlPostDiperhatikan);
        tvJmlPostKandidat = (TextView) findViewById(R.id.tv_jmlPostDariKandidat);

        btn_dariKandidat = (LinearLayout) findViewById(R.id.btn_dariKandidat);
        btn_dariKandidat.setOnClickListener(this);
        btn_diApresiasi = (LinearLayout) findViewById(R.id.btn_diApresiasi);
        btn_diApresiasi.setOnClickListener(this);
        btn_diPerhatikan = (LinearLayout) findViewById(R.id.btn_diPerhatikan);
        btn_diPerhatikan.setOnClickListener(this);

        adapter = new ApiAdapter();
        adapter.getRestApi().getKandidat(couple_id, new Callback<KandidatPojo>() {
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
                Intent dariKandidatIntent = new Intent(KandidatActivity.this, DariKandidatActivity.class);
                dariKandidatIntent.putExtra("couple_id", cpid);
                dariKandidatIntent.putExtra("from", "candidate");
                dariKandidatIntent.putExtra("feedback", 99);
                dariKandidatIntent.putExtra("province_name", province_name);
                dariKandidatIntent.putExtra("region_name", region_name);
                dariKandidatIntent.putExtra("calon_name", calon_name);
                dariKandidatIntent.putExtra("wakil_name", wakil_name);
                startActivity(dariKandidatIntent);
                break;

            case R.id.btn_diApresiasi:
                Intent diapresiasiIntent = new Intent(KandidatActivity.this, DiapresiasiActivity.class);
                diapresiasiIntent.putExtra("couple_id", cpid);
                diapresiasiIntent.putExtra("from", "candidate");
                diapresiasiIntent.putExtra("feedback", 1);
                diapresiasiIntent.putExtra("province_name", province_name);
                diapresiasiIntent.putExtra("region_name", region_name);
                diapresiasiIntent.putExtra("calon_name", calon_name);
                diapresiasiIntent.putExtra("wakil_name", wakil_name);
                startActivity(diapresiasiIntent);
                break;

            case R.id.btn_diPerhatikan:
                Intent diperhatikanIntent = new Intent(KandidatActivity.this, DiperhatikanActivity.class);
                diperhatikanIntent.putExtra("couple_id", cpid);
                diperhatikanIntent.putExtra("from", "candidate");
                diperhatikanIntent.putExtra("feedback", 0);
                diperhatikanIntent.putExtra("province_name", province_name);
                diperhatikanIntent.putExtra("region_name", region_name);
                diperhatikanIntent.putExtra("calon_name", calon_name);
                diperhatikanIntent.putExtra("wakil_name", wakil_name);
                startActivity(diperhatikanIntent);
                break;
        }
    }
}
