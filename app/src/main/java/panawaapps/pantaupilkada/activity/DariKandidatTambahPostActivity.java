package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import panawaapps.pantaupilkada.R;

public class DariKandidatTambahPostActivity extends AppCompatActivity {

    String daerah, namaCalon, namaWakil;

    TextView tvNamaCalon, tvNamaWakil, tvDaerah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dari_kandidat_tambah_post);

        Intent intent = this.getIntent();
        daerah = intent.getExtras().getString("daerah");
        namaCalon = intent.getExtras().getString("namacalon");
        namaWakil = intent.getExtras().getString("namawakil");

        tvNamaCalon = (TextView) findViewById(R.id.tv_namaCalon);
        tvNamaWakil = (TextView) findViewById(R.id.tv_namaWakil);

        tvNamaCalon.setText(namaCalon);
        tvNamaWakil.setText(namaWakil);
    }
}
