package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class DiapresiasiTambahPostActivity extends AppCompatActivity {

    String namaCalon, namaWakil, coupleid;
    TextView Calon, Wakil, btPost;
    EditText Judul, Isi;

    SharedPreferences pref;
    String token;

    ApiAdapter apiAdapter;

    CommentsData comments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diapresiasi_tambah_post);

        Intent intent = this.getIntent();

        namaCalon = intent.getExtras().getString("namacalon");
        namaWakil = intent.getExtras().getString("namawakil");
        coupleid = intent.getExtras().getString("coupleid");

        Calon = (TextView) findViewById(R.id.tv_namaCalon);
        Wakil = (TextView) findViewById(R.id.tv_namaWakil);

        Calon.setText(namaCalon);
        Wakil.setText(namaWakil);

        apiAdapter = new ApiAdapter();

        pref = PreferenceManager
                .getDefaultSharedPreferences(DiapresiasiTambahPostActivity.this);
        token = pref.getString("token", "");

        Judul = (EditText) findViewById(R.id.et_judulPost);
        Isi = (EditText) findViewById(R.id.et_isiPost);
        btPost = (TextView) findViewById(R.id.btn_post);

        btPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postDiapresiasi();
            }
        });

    }

    public void postDiapresiasi(){
        comments = new CommentsData();
        comments.setToken(token);
        comments.setCouple_id(coupleid);
        comments.setTitle(Judul.getText().toString());
        comments.setText(Isi.getText().toString());
        comments.setFeedback(1);

        apiAdapter.getRestApi().postComments(token, coupleid, comments.getTitle(), comments.getText(), comments.getFeedback(), new Callback<CommentsData>() {
            @Override
            public void success(CommentsData commentsData, Response response) {
                Toast.makeText(getApplicationContext(), "Komentar berhasil dikirim !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DiapresiasiTambahPostActivity.this, HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
