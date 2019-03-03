package com.zielinski.kacper.tourguideapp;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TourFragmentPagerAdapter tourFragmentPagerAdapter = new TourFragmentPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(tourFragmentPagerAdapter);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                menuItem -> {

                    menuItem.setChecked(true);
                    drawerLayout.closeDrawers();
                    displayFragment(menuItem.getItemId());

                    return true;
                });

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void displayFragment(int id)
    {
        switch(id)
        {
            case R.id.nav_places:
                viewPager.setCurrentItem(0);
                break;

            case R.id.nav_monuments:
                viewPager.setCurrentItem(1);
                break;

            case R.id.nav_restaurants:
                viewPager.setCurrentItem(2);
                break;

            case R.id.nav_parks:
                viewPager.setCurrentItem(3);
                break;
        }
    }
}
