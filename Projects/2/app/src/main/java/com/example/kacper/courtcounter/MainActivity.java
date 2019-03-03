package com.example.kacper.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreValueA;
    private int scoreValueB;
    private int faulValueA;
    private int faulValueB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("scoreValueA", scoreValueA);
        savedInstanceState.putInt("scoreValueB", scoreValueB);
        savedInstanceState.putInt("faulValueA", faulValueA);
        savedInstanceState.putInt("faulValueB", faulValueB);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

        scoreValueA = savedInstanceState.getInt("scoreValueA");
        scoreValueB = savedInstanceState.getInt("scoreValueB");
        faulValueA = savedInstanceState.getInt("faulValueA");
        faulValueB = savedInstanceState.getInt("faulValueB");

        updateValues();
    }

    private void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    private void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    private void displayFaulForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_fauls);
        scoreView.setText(String.valueOf(score));
    }

    private void displayFaulForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_fauls);
        scoreView.setText(String.valueOf(score));
    }

    private void updateValues()
    {
        displayScoreForTeamA(scoreValueA);
        displayScoreForTeamB(scoreValueB);
        displayFaulForTeamA(faulValueA);
        displayFaulForTeamB(faulValueB);
    }

    public void goalA(View view)
    {
        displayScoreForTeamA(++scoreValueA);
    }

    public void goalB(View view)
    {
        displayScoreForTeamB(++scoreValueB);
    }

    public void faulA(View view)
    {
        displayFaulForTeamA(++faulValueA);
    }

    public void faulB(View view)
    {
        displayFaulForTeamB(++faulValueB);
    }

    public void reset(View view)
    {
        scoreValueA=0;
        scoreValueB=0;
        faulValueA=0;
        faulValueB=0;

        updateValues();

    }
}
