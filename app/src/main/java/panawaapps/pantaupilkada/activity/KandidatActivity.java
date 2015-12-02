package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
    ImageView fotoCalon;
    ImageView fotoWakil;

    LinearLayout btn_dariKandidat;
    LinearLayout btn_diApresiasi;
    LinearLayout btn_diPerhatikan;

    String cpid;

    String candidate = "candidate";

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
        fotoCalon = (ImageView) findViewById(R.id.iv_fotoCalon);
        fotoWakil = (ImageView) findViewById(R.id.iv_fotoWakil);

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
                tvJmlPostKandidat.setText(String.valueOf(kandidatPojo.getData().getFromCandidates()));

                Picasso.with(KandidatActivity.this).load(kandidatPojo.getData().getCalonAvatar()).into(fotoCalon);
                Picasso.with(KandidatActivity.this).load(kandidatPojo.getData().getWakilAvatar()).into(fotoWakil);

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
                dariKandidatIntent.putExtra("from", candidate);
                dariKandidatIntent.putExtra("feedback", 0);
                dariKandidatIntent.putExtra("daerah", tvDaerahKandidat.getText());
                dariKandidatIntent.putExtra("calon_name", tvNamaCalon.getText());
                dariKandidatIntent.putExtra("wakil_name", tvNamaWakil.getText());
                startActivity(dariKandidatIntent);
                break;

            case R.id.btn_diApresiasi:
                Intent diapresiasiIntent = new Intent(KandidatActivity.this, DiapresiasiActivity.class);
                diapresiasiIntent.putExtra("couple_id", cpid);
                diapresiasiIntent.putExtra("from", "voter");
                diapresiasiIntent.putExtra("feedback", 1);
                diapresiasiIntent.putExtra("daerah", tvDaerahKandidat.getText());
                diapresiasiIntent.putExtra("calon_name", tvNamaCalon.getText());
                diapresiasiIntent.putExtra("wakil_name", tvNamaWakil.getText());
                startActivity(diapresiasiIntent);
                break;

            case R.id.btn_diPerhatikan:
                Intent diperhatikanIntent = new Intent(KandidatActivity.this, DiperhatikanActivity.class);
                diperhatikanIntent.putExtra("couple_id", cpid);
                diperhatikanIntent.putExtra("from", "voter");
                diperhatikanIntent.putExtra("feedback", 0);
                diperhatikanIntent.putExtra("daerah", tvDaerahKandidat.getText());
                diperhatikanIntent.putExtra("calon_name", tvNamaCalon.getText());
                diperhatikanIntent.putExtra("wakil_name", tvNamaWakil.getText());
                startActivity(diperhatikanIntent);
                break;
        }
    }
}
