package com.zielinski.kacper.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayerLoad();
    }

    private void mediaPlayerLoad()
    {
        Button playButton = (Button) findViewById(R.id.playMusic);
        Button pauseButton = (Button) findViewById(R.id.pauseMusic);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.depeche_mode_enjoy_the_silence);

        playButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mediaPlayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mediaPlayer.pause();
            }
        });
    }
}
