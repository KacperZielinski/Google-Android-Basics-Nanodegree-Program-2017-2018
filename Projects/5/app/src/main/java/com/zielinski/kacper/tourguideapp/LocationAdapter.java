package com.zielinski.kacper.tourguideapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location>{

    public LocationAdapter(Activity context, ArrayList<Location> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Location location = getItem(position);

        if (location != null) {

            if(location.hasImage()) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_white, parent, false);
                convertView.setBackgroundResource(location.getBackgroundImageResourceID());

                ImageView imageView = convertView.findViewById(R.id.list_item_icon_white);
                imageView.setImageResource(location.getIconResourceID());

                TextView nameTextView = convertView.findViewById(R.id.name_white);
                nameTextView.setText(location.getName());

            }
            else {
                ImageView imageView = convertView.findViewById(R.id.list_item_icon);
                imageView.setImageResource(location.getIconResourceID());

                TextView nameTextView = convertView.findViewById(R.id.name);
                nameTextView.setText(location.getName());
            }

        }

        return convertView;
    }
}
