package com.zielinski.kacper.musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class TrackAdapter extends ArrayAdapter<Track>
{
    public TrackAdapter(Activity context, ArrayList<Track> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Track track = getItem(position);

        if (track != null) {
            TextView songTextView = convertView.findViewById(R.id.song);
            songTextView.setText(track.getSongName());

            TextView artistTextView = convertView.findViewById(R.id.artist);
            artistTextView.setText(track.getArtistName());

            TextView durationTextView = convertView.findViewById(R.id.duration);
            durationTextView.setText(track.getDurationString());

        }

        return convertView;
    }
}
