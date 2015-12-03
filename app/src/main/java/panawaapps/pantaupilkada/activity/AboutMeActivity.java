package panawaapps.pantaupilkada.activity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.AboutMePagerAdapter;
import panawaapps.pantaupilkada.adapter.CardGroupAdapter;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.CardGroup;
import panawaapps.pantaupilkada.model.Status;
import panawaapps.pantaupilkada.model.UserProfile.UserProfile;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AboutMeActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    ImageView btn_editProfile, ivPengamat, ivPengawas, ivSaksi;
    TextView namaUser, deskripsi, pengamatCount, pengawasCount, saksiCount;

    CircleImageView fotoUser;

    ApiAdapter apiAdapter;

    String token;
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
        pengamatCount = (TextView) findViewById(R.id.tv_jumlahPeranPengamat);
        pengawasCount = (TextView) findViewById(R.id.tv_jumlahPeranPengawas);
        saksiCount = (TextView) findViewById(R.id.tv_jumlahPeranSaksi);
//
//        ivPengamat = (ImageView) findViewById(R.id.iv_btnPengamat);
//        ivPengawas = (ImageView) findViewById(R.id.iv_btnPengawas);
//        ivSaksi = (ImageView) findViewById(R.id.iv_btnSaksi);

//        ivPengamat.setOnClickListener(this);
//        ivPengawas.setOnClickListener(this);
//        ivSaksi.setOnClickListener(this);

        SharedPreferences settings = PreferenceManager
                .getDefaultSharedPreferences(AboutMeActivity.this);
        token = settings.getString("token", "");
        editor = settings.edit();


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
                pengamatCount.setText(String.valueOf(userProfile.getData().getAsObserver()));
                pengawasCount.setText(String.valueOf(userProfile.getData().getAsSupervisor()));
                saksiCount.setText(String.valueOf(userProfile.getData().getAsSpectator()));
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

    //------Kebutuhan Navigation Drawer
    @Override
    public void onBackPressed() {
//        Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
//        startActivity(intent);
//        finish();

        Intent intent = new Intent(AboutMeActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        //      MenuItem searchItem = menu.findItem(R.id.action_search);

        //     SearchManager searchManager = (SearchManager) HomeActivity.this.getSystemService(Context.SEARCH_SERVICE);

        //     SearchView searchView = null;
        //     if (searchItem != null) {
        //        searchView = (SearchView) searchItem.getActionView();
        //  }
        //if (searchView != null) {
        //searchView.setSearchableInfo(searchManager.getSearchableInfo(HomeActivity.this.getComponentName()));
        //}

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//
//        if (id == R.id.search_bar) {
//            return  true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id  = item.getItemId();

        if(id == R.id.nav_home) {
            Intent myIntent = new Intent(AboutMeActivity.this, HomeActivity.class);

            AboutMeActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengamat) {
            Intent myIntent = new Intent(AboutMeActivity.this, PengamatActivity.class);

            AboutMeActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_pengawas) {
//            Intent myIntent = new Intent(HomeActivity.this, PengawasActivity.class);
//
//            HomeActivity.this.startActivity(myIntent);
            Toast.makeText(getApplicationContext(), "Fitur ini tersedia pada Hari-H Pemilihan", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_saksi) {
//            Intent myIntent = new Intent(HomeActivity.this, SaksiActivity.class);
//
//            HomeActivity.this.startActivity(myIntent);
            Toast.makeText(getApplicationContext(), "Fitur ini tersedia pada Hari-H Pemilihan", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_kontestan) {

            Intent myIntent = new Intent(AboutMeActivity.this, DaftarKontestanActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            AboutMeActivity.this.startActivity(myIntent);

//        } else if (id == R.id.nav_group) {
//
//            Intent myIntent = new Intent(HomeActivity.this, DaftarGroupActivity.class);
//            //myIntent.putExtra("key", value); //Optional parameters
//            HomeActivity.this.startActivity(myIntent);


//        } else if (id == R.id.nav_aboutMe) {
//
//            Intent myIntent = new Intent(AboutMeActivity.this, AboutMeActivity.class);
//            //myIntent.putExtra("key", value); //Optional parameters
//            AboutMeActivity.this.startActivity(myIntent);


//        } else if (id == R.id.nav_group_tentang) {
//
//            Intent myIntent = new Intent(HomeActivity.this, GroupTentang.class);
//            //myIntent.putExtra("key", value); //Optional parameters
//            HomeActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_logOut) {

            new AlertDialog.Builder(AboutMeActivity.this)
                    .setTitle("Log out?")
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            //keluar
//                            HomeActivity.this.getSharedPreferences("token", 0).edit().clear().commit();
//                            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
//                            startActivity(intent);
                            Status status = new Status();
                            apiAdapter.getRestApi().Logout(token, new Callback<Status>() {
                                @Override
                                public void success(Status status, Response response) {
                                    editor.remove("token");
                                    editor.commit();

                                    Intent intent = new Intent(AboutMeActivity.this, MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                }

                                @Override
                                public void failure(RetrofitError error) {

                                }
                            });





                        }
                    })
                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();
            return false;
//
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
