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

import com.zielinski.kacper.tourguideapp.monuments.AnonymousPedestriansScrollingActivity;
import com.zielinski.kacper.tourguideapp.monuments.ChairScrollingActivity;
import com.zielinski.kacper.tourguideapp.monuments.NakedSwordsmanScrollingActivity;
import com.zielinski.kacper.tourguideapp.monuments.NeedleScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.KebabScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.PasibusScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.SetkaScrollingActivity;
import com.zielinski.kacper.tourguideapp.restaurants.SoczewkaScrollingActivity;

import java.util.ArrayList;

public class MonumentsFragment extends Fragment {
    private final ArrayList<Location> monuments = new ArrayList<>();
    private boolean areMonumentsAdded;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(!areMonumentsAdded)
            addMonuments();

        areMonumentsAdded = true;
        return inflater.inflate(R.layout.fragment_monuments, container, false);
    }

    private void addMonuments() {
        monuments.add(new Location(getString(R.string.chair_str), R.drawable.chair, R.drawable.chair2, ChairScrollingActivity.class));
        monuments.add(new Location(getString(R.string.needle_str), R.drawable.height, R.drawable.iglica, NeedleScrollingActivity.class));
        monuments.add(new Location(getString(R.string.naked_swordman_str), R.drawable.statue, R.drawable.naked_swordman, NakedSwordsmanScrollingActivity.class));
        monuments.add(new Location(getString(R.string.anonymous_pedestrians_str), R.drawable.monument, R.drawable.anonymous_pedestrains, AnonymousPedestriansScrollingActivity.class));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), monuments);
        GridView gridView = view.findViewById(R.id.monuments_listview);
        gridView.setAdapter(locationAdapter);

        gridView.setOnItemClickListener((adapterView, view1, i, l) -> {
            Intent intent = new Intent(getActivity(), monuments.get(i).getActivity());
            startActivity(intent);
        });
    }
}
