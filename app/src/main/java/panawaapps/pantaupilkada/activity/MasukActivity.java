package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import panawaapps.pantaupilkada.R;

public class MasukActivity extends AppCompatActivity implements View.OnClickListener {

    TextView btn_daftar, btn_masuk;
//    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        btn_daftar = (TextView) findViewById(R.id.bDaftar);
        btn_masuk = (TextView) findViewById(R.id.bMasuk);

        btn_daftar.setOnClickListener(this);
        btn_masuk.setOnClickListener(this);

//        userLocalStore = new UserLocalStore(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bMasuk:
//                User user = new User(null, null);
//
//                userLocalStore.storeUserData(user);
//                userLocalStore.setUserLoggedIn(true);

                startActivity(new Intent(this, HomeActivity.class));
                break;

            case R.id.bDaftar:
                startActivity(new Intent(this, DaftarActivity.class));
                break;
        }
    }
}
