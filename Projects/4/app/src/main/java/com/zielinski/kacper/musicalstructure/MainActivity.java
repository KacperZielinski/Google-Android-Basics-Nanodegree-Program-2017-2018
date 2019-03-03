package com.zielinski.kacper.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Track track;
    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        track = i.getParcelableExtra("track");

        if(track == null)
            track = new Track("", "", 0);

        TextView song = findViewById(R.id.played_song);
        TextView artist = findViewById(R.id.played_artist);
        TextView durationTextView = findViewById(R.id.played_duration);

        song.setText(track.getSongName());
        artist.setText(track.getArtistName());
        durationTextView.setText(track.getDurationString());

        Button goToLibrary = findViewById(R.id.library_button);
        int myColor = getResources().getColor(R.color.colorPrimary);
        goToLibrary.setBackgroundColor(myColor);
        goToLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent library = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(library);
            }
        });

        final Button playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isPlaying)
                {
                    playButton.setBackgroundResource(R.drawable.ic_pause);
                    isPlaying = true;
                }
                else
                {
                    playButton.setBackgroundResource(R.drawable.ic_play);
                    isPlaying = false;
                }
            }
        });

        ImageView backwardImageView = findViewById(R.id.backward_image_view);
        ImageView forwardImageView = findViewById(R.id.forward_image_view);

        backwardImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        forwardImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelable("track", track);
        savedInstanceState.putBoolean("isPlaying", isPlaying);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        track = savedInstanceState.getParcelable("track");
        isPlaying = savedInstanceState.getBoolean("isPlaying");
    }
}
