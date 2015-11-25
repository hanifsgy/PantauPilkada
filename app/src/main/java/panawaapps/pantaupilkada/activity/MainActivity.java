package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import panawaapps.pantaupilkada.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_daftar, btn_masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_daftar = (Button) findViewById(R.id.bDaftar);
        btn_masuk = (Button) findViewById(R.id.bMasuk);

        btn_daftar.setOnClickListener(this);
        btn_masuk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bDaftar:
                startActivity(new Intent(this, DaftarActivity.class));
                break;
            case R.id.bMasuk:
                startActivity(new Intent(this, MasukActivity.class));
                break;
        }
    }
}
