package panawaapps.pantaupilkada.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.PremiumReply;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ReplyHomeActivity extends AppCompatActivity implements View.OnClickListener {


   public List<PremiumReply> premiumReplyList;

    ApiAdapter apiAdapter;

    String token;
    String commentId;
    String judulComment;
    String namaProvinsi;
    String namaCalon;
    String namaWakil;
    String isiComment;
    String tglComment;
    String personName;
    String isiReply;
//    String tglReply;
    int feedback;
    int jmlApresiasi;
    int jmlPerhatikan;

    TextView commentTitle;
    TextView commentProvinsi;
    TextView commentCalon;
    TextView commentWakil;
    TextView commentIsi;
    TextView commentTgl;
    TextView commentPerson;
    TextView commentJmlApresiasi;
    TextView commentJmlPerhatikan;
    EditText tulisReply;
    TextView btnPostReply;
    LinearLayout cardReply;
    TextView replyIsi;
    TextView replyTgl;
    FrameLayout btnApresiasi;
    FrameLayout btnPerhatian;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_home);

        apiAdapter = new ApiAdapter();

        SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(ReplyHomeActivity.this);
        token = settings.getString("token", "");

        Intent intent = this.getIntent();
        judulComment = intent.getExtras().getString("judul");
        isiComment = intent.getExtras().getString("text");
        commentId = intent.getExtras().getString("commentId");
        namaProvinsi = intent.getExtras().getString("namaProvinsi");
        feedback = intent.getExtras().getInt("feedback");
        jmlApresiasi = intent.getExtras().getInt("jmlApresiasi");
        jmlPerhatikan = intent.getExtras().getInt("jmlPerhatikan");
        namaCalon = intent.getExtras().getString("namaCalon");
        namaWakil = intent.getExtras().getString("namaWakil");
        tglComment = intent.getExtras().getString("tglComment").substring(0,10);
        personName = intent.getExtras().getString("personName");

        commentTitle = (TextView) findViewById(R.id.tv_judulReply);
        commentProvinsi = (TextView) findViewById(R.id.tv_namaProvinsi);
        commentCalon = (TextView) findViewById(R.id.tv_namaCalon);
        commentWakil = (TextView) findViewById(R.id.tv_namaWakil);
        commentIsi = (TextView) findViewById(R.id.tv_isiPostHome);
        commentTgl = (TextView) findViewById(R.id.tv_tglPostHome);
        commentPerson = (TextView) findViewById(R.id.tv_personName);
        commentJmlApresiasi = (TextView) findViewById(R.id.tv_jmlApresiasi);
        commentJmlPerhatikan = (TextView) findViewById(R.id.tv_jmlPerhatian);
        tulisReply = (EditText) findViewById(R.id.et_tulisReply);
        btnPostReply = (TextView) findViewById(R.id.btn_postReply);
        cardReply = (LinearLayout) findViewById(R.id.card_reply);
        replyIsi = (TextView) findViewById(R.id.tv_isiReply);
        replyTgl = (TextView) findViewById(R.id.tv_tglReply);
        btnApresiasi = (FrameLayout) findViewById(R.id.btn_apresiasi);
        btnPerhatian = (FrameLayout) findViewById(R.id.btn_perhatian);

        commentTitle.setText(judulComment);
        commentProvinsi.setText(namaProvinsi);
        commentCalon.setText(namaCalon);
        commentWakil.setText(namaWakil);
        commentIsi.setText(isiComment);
        commentTgl.setText(tglComment);
        commentPerson.setText(personName);

        if(feedback == 1){
            btnApresiasi.setVisibility(View.VISIBLE);
        } else
        if(feedback == 0){
            btnApresiasi.setVisibility(View.VISIBLE);
        } else
        if (feedback == 99){
            btnApresiasi.setVisibility(View.VISIBLE);
            btnApresiasi.setVisibility(View.VISIBLE);
        }
        if(jmlApresiasi != 0){
            commentJmlApresiasi.setVisibility(View.VISIBLE);
            commentJmlApresiasi.setText(String.valueOf(jmlApresiasi));
        }
        if(jmlPerhatikan != 0){
            commentJmlPerhatikan.setVisibility(View.VISIBLE);
            commentJmlPerhatikan.setText(String.valueOf(jmlPerhatikan));
        }

        btnPostReply.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_postReply:
                postReply();
                break;
        }
    }

    private void postReply() {
        isiReply = tulisReply.getText().toString();
//        Toast.makeText(getApplicationContext(), token + ", "+ commentId + ", "+ isiReply, Toast.LENGTH_SHORT).show();
        apiAdapter.getRestApi().replyPremium(commentId, token, isiReply, new Callback<PremiumReply>() {
            @Override
            public void success(PremiumReply premiumReply, Response response) {
                Toast.makeText(getApplicationContext(), "Respon berhasil dikirim !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ReplyHomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
