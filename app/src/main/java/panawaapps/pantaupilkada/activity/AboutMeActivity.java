package panawaapps.pantaupilkada.activity;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.widget.ImageView;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.AboutMePagerAdapter;
import panawaapps.pantaupilkada.adapter.CardGroupAdapter;
import panawaapps.pantaupilkada.model.CardGroup;

public class AboutMeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView btn_editProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        btn_editProfile = (ImageView) findViewById(R.id.btn_editProfile);
        btn_editProfile.setOnClickListener(this);

        ViewPager pager = (ViewPager) findViewById(R.id.viewpager_aboutMe);
        pager.setAdapter(new AboutMePagerAdapter(getSupportFragmentManager()));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs_aboutMe);
        tabs.setViewPager(pager);


    }

    //wrong
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_editProfile:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
        }
    }

}
