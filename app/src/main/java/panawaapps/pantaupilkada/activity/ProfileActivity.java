package panawaapps.pantaupilkada.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.UserData.UserData;
import panawaapps.pantaupilkada.model.UserProfile.UserProfile;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences settings;

    EditText etName, etPassword, etBio;
    TextView tvPengamat, tvPengawas, tvSaksi, btSave;

    ApiAdapter apiAdapter;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etName = (EditText) findViewById(R.id.et_userName);
        etPassword = (EditText) findViewById(R.id.et_password);
        etBio = (EditText) findViewById(R.id.et_bio);
        tvPengamat = (TextView) findViewById(R.id.tv_pengamat);
        tvPengawas = (TextView) findViewById(R.id.tv_pengawas);
        tvSaksi = (TextView) findViewById(R.id.tv_saksi);

        btSave = (TextView) findViewById(R.id.btn_save);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }
        });

        settings = PreferenceManager
                .getDefaultSharedPreferences(ProfileActivity.this);
        token = settings.getString("token", "");

        apiAdapter = new ApiAdapter();
        getUserData();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getUserData(){
        apiAdapter.getRestApi().getMyProfile(token, new Callback<UserProfile>() {
            @Override
            public void success(UserProfile userProfile, Response response) {
                etName.setHint(userProfile.getData().getName());
                if (userProfile.getData().getDescription() == null){
                    etBio.setHint("Belum ada bio");
                }else {
                    etBio.setHint(String.valueOf(userProfile.getData().getDescription()));
                }

                tvPengamat.setText(userProfile.getData().getAsObserver().toString());
                tvPengawas.setText(userProfile.getData().getAsSupervisor().toString());
                tvSaksi.setText(userProfile.getData().getAsSpectator().toString());

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void updateProfile(){
        apiAdapter.getRestApi().updateProfile(token, etName.getText().toString(), etBio.getText().toString(), new Callback<UserData>() {
            @Override
            public void success(UserData userData, Response response) {
                Toast.makeText(getApplicationContext(), "Profil berhasil diperbarui", Toast.LENGTH_SHORT).show();
                getUserData();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}
