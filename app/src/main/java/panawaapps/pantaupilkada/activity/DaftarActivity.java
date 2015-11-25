package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import panawaapps.pantaupilkada.R;

public class DaftarActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_daftar;
    EditText etNama, etEmail, etPassword, etRePassword, etAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        btn_daftar = (Button) findViewById(R.id.bDaftar);
        etNama = (EditText) findViewById(R.id.etNamaUser);
        etEmail = (EditText) findViewById(R.id.etEmailUser);
        etPassword = (EditText) findViewById(R.id.etPasswordUser);
        etRePassword = (EditText) findViewById(R.id.etRePasswordUser);

        btn_daftar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bDaftar:
                /*String nama = etNama.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String repassword = etRePassword.getText().toString();
                String alamat = etAlamat.getText().toString();*/
                startActivity(new Intent(this, HomeActivity.class));
                //User registeredData = new User(nama, email, password, repassword, alamat);

                break;
        }
    }
}