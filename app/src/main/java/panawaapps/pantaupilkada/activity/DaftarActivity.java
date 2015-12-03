package panawaapps.pantaupilkada.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.UserData.UserData;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DaftarActivity extends AppCompatActivity implements View.OnClickListener{

    DateFormat format = DateFormat.getDateInstance();
    Calendar calendar = Calendar.getInstance();

    ApiAdapter apiAdapter;

    TextView btnDate;
    TextView btDaftar;

    EditText etEmail, etPassword, etRePassword, etName, etAlamat;
    TextView tvDob,syaratKetentuan;

    CheckBox checkBox;

    UserData userData;

    boolean setuju = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        apiAdapter = new ApiAdapter();

        etEmail = (EditText) findViewById(R.id.etEmailUser);
        etPassword = (EditText) findViewById(R.id.etPasswordUser);
        etRePassword = (EditText) findViewById(R.id.etRePasswordUser);
        tvDob = (TextView) findViewById(R.id.TxtDate);
        etName = (EditText) findViewById(R.id.etNewNamaUser);
        etAlamat = (EditText) findViewById(R.id.etAlamatUser);

        btDaftar = (TextView) findViewById(R.id.bDaftarBaru);
        btnDate = (TextView) findViewById(R.id.TxtDate);
        btnDate.setOnClickListener(this);
        btDaftar.setOnClickListener(this);
        syaratKetentuan = (TextView) findViewById(R.id.btn_syaratKetentuan);
        syaratKetentuan.setOnClickListener(this);
        checkBox = (CheckBox) findViewById(R.id.checkbox);


    }


    @Override
    public void onClick(View v) {


        switch(v.getId()){
            case R.id.TxtDate:
                setDate();
                break;
            case R.id.bDaftarBaru:
                if(checkBox.isChecked()){
                    setuju = true;
                } else {
                    setuju = false;
                }
                if (setuju == true){
                    if (!etEmail.getText().toString().trim().contains("@") || !etEmail.getText().toString().trim().contains(".com")){
                        etEmail.setError("Format alamat email salah");
                    } else if (etPassword.getText().toString().length() < 8){
                        etPassword.setError("Masukan password lebih dari 8 karakter");
                    } else
                    if (!etRePassword.getText().toString().equals(etPassword.getText().toString())){
                        etRePassword.setError("Password tidak sama");
//                        Toast.makeText(getApplicationContext(), etRePassword.getText().toString() + ", " +etPassword.getText().toString(), Toast.LENGTH_SHORT).show();
                    } else
                    storeUser();
                } else {
                    Toast.makeText(getApplicationContext(), "Anda harus setuju terhadap syarat & ketentuan", Toast.LENGTH_SHORT).show();
                }



                break;
            case R.id.btn_syaratKetentuan:
                Intent intent = new Intent(DaftarActivity.this, SyaratKetentuanActivity.class);
                startActivity(intent);
        }

    }


    public void setDate(){
        new DatePickerDialog(DaftarActivity.this, d, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            dateSelected();
        }
    };

    public void dateSelected(){
        btnDate.setText(format.format(calendar.getTime()));
    }





    public void storeUser(){

        userData = new UserData();
        userData.setName(etName.getText().toString());
        userData.setEmail(etEmail.getText().toString());
        userData.setPassword(etPassword.getText().toString());
        userData.setPassword_confirmation(etRePassword.getText().toString());
        userData.setDob(tvDob.getText().toString());
        userData.setAddress(etAlamat.getText().toString());

        apiAdapter.getRestApi().sendUserData(userData.getEmail(), userData.getPassword(), userData.getPassword_confirmation(), userData.getName(), userData.getDob(), userData.getAddress(), null, new Callback<UserData>() {
            @Override
            public void success(UserData userData, Response response) {
                Toast.makeText(getApplicationContext(), "Berhasil Mendaftar. Silahkan Login", Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(DaftarActivity.this, MasukActivity.class);
                startActivity(loginIntent);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "Masukkan data yang valid", Toast.LENGTH_SHORT).show();
            }
        });
    }
}