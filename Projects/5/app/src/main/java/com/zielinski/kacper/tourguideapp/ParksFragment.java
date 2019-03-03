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

import com.zielinski.kacper.tourguideapp.parks.GrabiszynskiScrollingActivity;
import com.zielinski.kacper.tourguideapp.parks.PoludniowyScrollingActivity;
import com.zielinski.kacper.tourguideapp.parks.StaromiejskiScrollingActivity;
import com.zielinski.kacper.tourguideapp.parks.SzczytnickiScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.KebabScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.PasibusScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.SetkaScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.SoczewkaScrollingActivity;

import java.util.ArrayList;

public class ParksFragment extends Fragment
{
    private final ArrayList<Location> parks = new ArrayList<>();
    private boolean areParksAdded;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(!areParksAdded)
            addParks();

        areParksAdded = true;
        return inflater.inflate(R.layout.fragment_parks, container, false);
    }

    private void addParks() {
        parks.add(new Location(getString(R.string.grabiszynski_str), R.drawable.park2, GrabiszynskiScrollingActivity.class));
        parks.add(new Location(getString(R.string.poludniowy_str), R.drawable.tree, PoludniowyScrollingActivity.class));
        parks.add(new Location(getString(R.string.staromiejski_str), R.drawable.leaf, StaromiejskiScrollingActivity.class));
        parks.add(new Location(getString(R.string.szczytnicki_str), R.drawable.bench, SzczytnickiScrollingActivity.class));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), parks);
        GridView gridView = view.findViewById(R.id.parks_listview);
        gridView.setAdapter(locationAdapter);

        gridView.setOnItemClickListener((adapterView, view1, i, l) -> {
            Intent intent = new Intent(getActivity(), parks.get(i).getActivity());
            startActivity(intent);
        });
    }
}
