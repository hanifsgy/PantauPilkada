package panawaapps.pantaupilkada.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;
import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.UserData.UserData;
import panawaapps.pantaupilkada.model.UserProfile.UserProfile;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;

public class ProfileActivity extends AppCompatActivity {

    String[] perms = {"android.permission.READ_EXTERNAL_STORAGE"};

    SharedPreferences settings;

    EditText etName, etPassword, etBio;
    TextView tvPengamat, tvPengawas, tvSaksi, btSave;

    CircleImageView ivAvatar;

    ApiAdapter apiAdapter;
    String token;
    TypedFile imagePath;
    ProgressDialog dialog;

    boolean readAccepted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        settings = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this);
        token = settings.getString("token", "");

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            readAccepted = shouldWeAsk();
            if (readAccepted) {
                requestPermissions(perms, 200);
            }
        } else {
            readAccepted = true;
        }

        etName = (EditText) findViewById(R.id.et_userName);
//        etPassword = (EditText) findViewById(R.id.et_password);
        etBio = (EditText) findViewById(R.id.et_bio);
        tvPengamat = (TextView) findViewById(R.id.tv_pengamat);
        tvPengawas = (TextView) findViewById(R.id.tv_pengawas);
        tvSaksi = (TextView) findViewById(R.id.tv_saksi);

        btSave = (TextView) findViewById(R.id.btn_save);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (imagePath != null && readAccepted)
//                    postImage();
//                else
                postImage();
                updateProfile();
                Intent intent = new Intent(ProfileActivity.this, AboutMeActivity.class);
                startActivity(intent);
            }
        });

        ivAvatar = (CircleImageView) findViewById(R.id.ivAvatar);
        ivAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 2);
            }
        });

        apiAdapter = new ApiAdapter();
        getUserData();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                //Display an error
                return;
            }

            Uri selectedImage = data.getData();

            String[] projection = {MediaStore.MediaColumns.DATA};
            Cursor cursor = managedQuery(selectedImage, projection, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            cursor.moveToFirst();
            String path = cursor.getString(column_index);
            File file = new File(path);

            if (file.length() > 1000000) {
                Toast.makeText(this, "Image is too large", Toast.LENGTH_SHORT).show();
                return;
            }
            ivAvatar.setImageURI(selectedImage);
            String type = null;
            String extension = MimeTypeMap.getFileExtensionFromUrl(path);
            if (extension != null) {
                type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            }
            imagePath = new TypedFile(type, file);
            Log.d("MyLogs", "Path - " + file.getAbsolutePath());
            Log.d("MyLogs", "Path - " + file.getAbsoluteFile());
        }
    }

    private void postImage() {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(false);
            dialog.setMessage("Uploading...");
        }
        dialog.show();
        apiAdapter.getRestApi().updateAvatar(token, imagePath, new Callback<String>() {
            @Override
            public void success(String userData, Response response) {
                Log.d("MyLogs", "URL - " + userData);
                updateProfile();
                dialog.dismiss();
                Toast.makeText(ProfileActivity.this, "Data uploaded successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("MyLogs", "Error - " + error.getMessage());
                dialog.dismiss();
                Toast.makeText(ProfileActivity.this, "Error - " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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

    public void getUserData() {
        apiAdapter.getRestApi().getMyProfile(token, new Callback<UserProfile>() {
            @Override
            public void success(UserProfile userProfile, Response response) {
                etName.setText(userProfile.getData().getName());
                if (userProfile.getData().getDescription() == null) {
                    etBio.setText("Belum ada deskripsi bio");
                } else {
                    etBio.setText(String.valueOf(userProfile.getData().getDescription()));
                }
                tvPengamat.setText(userProfile.getData().getAsObserver().toString());
                tvPengawas.setText(userProfile.getData().getAsSupervisor().toString());
                tvSaksi.setText(userProfile.getData().getAsSpectator().toString());
                Picasso.with(ProfileActivity.this).load(userProfile.getData().getAvatarUrl()).into(ivAvatar);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void updateProfile() {
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

    @Override

    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults) {
        switch (permsRequestCode) {
            case 200:
                readAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                markAsAsked();
                break;
        }
    }

    private boolean shouldWeAsk() {
        return (settings.getBoolean("permission", true));

    }


    private void markAsAsked() {
        settings.edit().putBoolean("permission", false).apply();
    }

}