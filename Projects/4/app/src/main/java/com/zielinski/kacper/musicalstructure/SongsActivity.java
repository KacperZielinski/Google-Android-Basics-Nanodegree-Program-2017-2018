package com.zielinski.kacper.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        final ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("Song1", "Artist1", 180));
        tracks.add(new Track("Song2", "Artist1", 240));
        tracks.add(new Track("Song3", "Artist1", 210));
        tracks.add(new Track("Song4", "Artist2", 243));
        tracks.add(new Track("Song5", "Artist2", 188));
        tracks.add(new Track("Song6", "Artist2", 233));
        tracks.add(new Track("Song7", "Artist3", 129));
        tracks.add(new Track("Song8", "Artist3", 280));
        tracks.add(new Track("Song9", "Artist3", 342));

        TrackAdapter trackAdapter = new TrackAdapter(this, tracks);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(trackAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Track track = tracks.get(i);
                Intent goToPlayer = new Intent(SongsActivity.this, MainActivity.class);
                goToPlayer.putExtra("track", track);
                startActivity(goToPlayer);
            }
        });
    }
}
