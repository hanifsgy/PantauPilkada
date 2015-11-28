package panawaapps.pantaupilkada.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.AboutMePagerAdapter;
import panawaapps.pantaupilkada.adapter.CardGroupAdapter;
import panawaapps.pantaupilkada.model.CardGroup;

public class AboutMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        ViewPager pager = (ViewPager) findViewById(R.id.viewpager_aboutMe);
        pager.setAdapter(new AboutMePagerAdapter(getSupportFragmentManager()));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs_aboutMe);
        tabs.setViewPager(pager);
    }
}
