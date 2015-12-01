package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.PostComments.CommentsData;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DariKandidatTambahPostActivity extends AppCompatActivity {

    String coupleid, namaCalon, namaWakil;
    String title, text;

    TextView tvNamaCalon, tvNamaWakil;

    ApiAdapter apiAdapter;


    EditText Judul, Isi;
    TextView btPost;

    CommentsData comments;

    SharedPreferences pref;
    String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dari_kandidat_tambah_post);

        Intent intent = this.getIntent();

        namaCalon = intent.getExtras().getString("namacalon");
        namaWakil = intent.getExtras().getString("namawakil");
        coupleid = intent.getExtras().getString("coupleid");
        apiAdapter = new ApiAdapter();

        tvNamaCalon = (TextView) findViewById(R.id.tv_namaCalon);
        tvNamaWakil = (TextView) findViewById(R.id.tv_namaWakil);

        tvNamaCalon.setText(namaCalon);
        tvNamaWakil.setText(namaWakil);

        pref = PreferenceManager
                .getDefaultSharedPreferences(DariKandidatTambahPostActivity.this);
        token = pref.getString("token", "");


        Judul = (EditText) findViewById(R.id.et_judulPost);
        Isi = (EditText) findViewById(R.id.et_isiPost);
        btPost = (TextView) findViewById(R.id.btn_post);





        btPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postComments();
            }
        });

    }

    public void postComments(){
        comments = new CommentsData();
        comments.setToken(token);
        comments.setCouple_id(coupleid);
        comments.setTitle(Judul.getText().toString());
        comments.setText(Isi.getText().toString());
        comments.setFeedback(0);

        apiAdapter.getRestApi().postComments(comments.getToken(), comments.getCouple_id(), comments.getTitle(), comments.getText(), comments.getFeedback(), new Callback<CommentsData>() {
            @Override
            public void success(CommentsData commentsData, Response response) {
                Toast.makeText(getApplicationContext(), "Komentar berhasil dikirim !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DariKandidatTambahPostActivity.this, HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
