package io.aigb.petori.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.aigb.petori.R;
import io.aigb.petori.views.fragment.HomeFragment;
import io.aigb.petori.views.fragment.PesananFragment;
import io.aigb.petori.views.fragment.ProfileFragment;

public class HomeActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,
    PesananFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener, View.OnClickListener {

    BottomNavigationView bottomNav = null;
    BottomNavigationItemView navHome, navPesanan, navInbox, navProfil;




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;
                case R.id.navigation_pesanan:
                    fragment = new PesananFragment();
                    break;
                case R.id.navigation_profil:
                    fragment = new ProfileFragment();
                    break;
            }
            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        navHome = (BottomNavigationItemView) findViewById(R.id.navigation_home);
        navPesanan = (BottomNavigationItemView) findViewById(R.id.navigation_pesanan);
        navProfil = (BottomNavigationItemView) findViewById(R.id.navigation_profil);
//        bottomNav.setItemIconTintList(null);






        loadFragment(new HomeFragment());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void gotoLayananDetail(View v) {
        Intent i = new Intent(HomeActivity.this, LayananDetailActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_layanan1:
//                Intent i = new Intent(HomeActivity.this, LayananDetailActivity.class);
//                startActivity(i);
                break;
        }
    }
}
