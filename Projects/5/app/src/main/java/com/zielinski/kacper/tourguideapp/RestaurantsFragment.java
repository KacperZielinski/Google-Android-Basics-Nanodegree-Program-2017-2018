package com.zielinski.kacper.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.zielinski.kacper.tourguideapp.restaurants.KebabScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.PasibusScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.SetkaScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.SoczewkaScrollingActivity;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {

    private final ArrayList<Location> restaurants = new ArrayList<>();
    private boolean areRestaurantsAdded;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(!areRestaurantsAdded)
            addRestaurants();

        areRestaurantsAdded = true;
        return inflater.inflate(R.layout.fragment_restaurants, container, false);
    }

    private void addRestaurants() {
        restaurants.add(new Location(getString(R.string.kebab_str), R.drawable.kebab, KebabScrollingActivity.class));
        restaurants.add(new Location(getString(R.string.setka_str), R.drawable.vodka, SetkaScrollingActivity.class));
        restaurants.add(new Location(getString(R.string.pasibus_str), R.drawable.hamburger, PasibusScrollingActivity.class));
        restaurants.add(new Location(getString(R.string.soczewka_str), R.drawable.restaurant, SoczewkaScrollingActivity.class));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), restaurants);
        GridView gridView = view.findViewById(R.id.restaurant_listview);
        gridView.setAdapter(locationAdapter);

        gridView.setOnItemClickListener((adapterView, view1, i, l) -> {
            Intent intent = new Intent(getActivity(), restaurants.get(i).getActivity());
            startActivity(intent);
        });
    }


}
