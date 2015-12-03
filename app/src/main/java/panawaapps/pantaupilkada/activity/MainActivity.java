package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

import panawaapps.pantaupilkada.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // textview
    TextView btn_daftar, btn_masuk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(MainActivity.this);
        String auth_token_string = settings.getString("token", "");
        if (getIntent().getBooleanExtra("EXIT", false)){
            finish();
        }else {
            if (!Objects.equals(auth_token_string, "")){
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }

        btn_daftar = (TextView) findViewById(R.id.bDaftar);
        btn_masuk = (TextView) findViewById(R.id.bMasuk);

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        this.finish();

    }


}
