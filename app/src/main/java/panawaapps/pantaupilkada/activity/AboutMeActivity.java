package panawaapps.pantaupilkada.activity;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.AboutMePagerAdapter;
import panawaapps.pantaupilkada.adapter.CardGroupAdapter;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.CardGroup;
import panawaapps.pantaupilkada.model.UserProfile.UserProfile;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AboutMeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView btn_editProfile, ivPengamat, ivPengawas, ivSaksi;
    TextView namaUser, deskripsi, pengamatCount, pengawasCount, saksiCount;

    CircleImageView fotoUser;

    ApiAdapter apiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        btn_editProfile = (ImageView) findViewById(R.id.btn_editProfile);
        btn_editProfile.setOnClickListener(this);
//
//        ViewPager pager = (ViewPager) findViewById(R.id.viewpager_aboutMe);
//        pager.setAdapter(new AboutMePagerAdapter(getSupportFragmentManager()));

//        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs_aboutMe);
//        tabs.setViewPager(pager);

        fotoUser = (CircleImageView) findViewById(R.id.civ_fotoUser);

        namaUser = (TextView) findViewById(R.id.tv_namaUser);
        deskripsi = (TextView) findViewById(R.id.tv_deskripsiUser);
//        pengamatCount = (TextView) findViewById(R.id.tv_jumlahPeranPengamat);
//        pengawasCount = (TextView) findViewById(R.id.tv_jumlahPeranPengawas);
//        saksiCount = (TextView) findViewById(R.id.tv_jumlahPeranSaksi);
//
//        ivPengamat = (ImageView) findViewById(R.id.iv_btnPengamat);
//        ivPengawas = (ImageView) findViewById(R.id.iv_btnPengawas);
//        ivSaksi = (ImageView) findViewById(R.id.iv_btnSaksi);

//        ivPengamat.setOnClickListener(this);
//        ivPengawas.setOnClickListener(this);
//        ivSaksi.setOnClickListener(this);

        SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(AboutMeActivity.this);
        String token = settings.getString("token", "");


        apiAdapter =new ApiAdapter();
        apiAdapter.getRestApi().getMyProfile(token, new Callback<UserProfile>() {
            @Override
            public void success(UserProfile userProfile, Response response) {

                Picasso.with(AboutMeActivity.this).load(userProfile.getData().getAvatarUrl()).into(fotoUser);
                namaUser.setText(userProfile.getData().getName());
                if (userProfile.getData().getDescription() == null){
                    deskripsi.setText("Belum ada Deskripsi");
                }
                else {
                    deskripsi.setText(String.valueOf(userProfile.getData().getDescription()));
                }
//                pengamatCount.setText(String.valueOf(userProfile.getData().getAsObserver()));
//                pengawasCount.setText(String.valueOf(userProfile.getData().getAsSupervisor()));
//                saksiCount.setText(String.valueOf(userProfile.getData().getAsSpectator()));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });


    }

    //wrong
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_editProfile:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
//            case R.id.iv_btnPengamat:
//                startActivity(new Intent(this, PengamatActivity.class));
//                break;
//            case R.id.iv_btnPengawas:
//                startActivity(new Intent(this, PengawasActivity.class));
//                break;
//            case R.id.iv_btnSaksi:
//                startActivity(new Intent(this, SaksiActivity.class));
//                break;
        }
    }

}
