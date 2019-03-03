package com.zielinski.kacper.tourguideapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TourFragmentPagerAdapter extends FragmentPagerAdapter
{
    private final Context context;

    public TourFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PlacesFragment();
            case 1:
                return new MonumentsFragment();
            case 2:
                return new RestaurantsFragment();
            case 3:
                return new ParksFragment();
            default:
                return new PlacesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.places);
            case 1:
                return context.getString(R.string.monuments);
            case 2:
                return context.getString(R.string.restaurants);
            case 3:
                return context.getString(R.string.parks);
            default:
                return context.getString(R.string.places);
        }
    }
}
