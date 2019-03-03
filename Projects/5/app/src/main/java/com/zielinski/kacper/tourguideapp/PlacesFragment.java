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

import com.zielinski.kacper.tourguideapp.places.MarketplaceScrollingActivity;
import com.zielinski.kacper.tourguideapp.places.MultimediaFountainScrollingActivity;
import com.zielinski.kacper.tourguideapp.places.RaclawicePanoramaScrollingActivity;
import com.zielinski.kacper.tourguideapp.places.ZooScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.KebabScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.PasibusScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.SetkaScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.SoczewkaScrollingActivity;

import java.util.ArrayList;


public class PlacesFragment extends Fragment {

    private final ArrayList<Location> places = new ArrayList<>();
    private boolean arePlacesAdded;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(!arePlacesAdded)
            addPlaces();

        arePlacesAdded = true;
        return inflater.inflate(R.layout.fragment_places, container, false);
    }

    private void addPlaces() {
        places.add(new Location(getString(R.string.marketplace_str), R.drawable.marketplace, MarketplaceScrollingActivity.class));
        places.add(new Location(getString(R.string.zoo_str), R.drawable.zoo, ZooScrollingActivity.class));
        places.add(new Location(getString(R.string.multimedia_fountain_str), R.drawable.fountain, MultimediaFountainScrollingActivity.class));
        places.add(new Location(getString(R.string.raclawice_panorama_str), R.drawable.panorama, RaclawicePanoramaScrollingActivity.class));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), places);
        GridView gridView = view.findViewById(R.id.places_listview);
        gridView.setAdapter(locationAdapter);

        gridView.setOnItemClickListener((adapterView, view1, i, l) -> {
            Intent intent = new Intent(getActivity(), places.get(i).getActivity());
            startActivity(intent);
        });
    }
}
