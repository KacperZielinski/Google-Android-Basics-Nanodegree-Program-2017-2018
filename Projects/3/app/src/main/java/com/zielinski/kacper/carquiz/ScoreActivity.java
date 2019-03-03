package com.zielinski.kacper.carquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Activity which shows score of quiz
 */
public class ScoreActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent = getIntent();
        int questionNumber = QuizQuestions.getSize();
        int n = intent.getIntExtra("score", questionNumber);

        if(n == questionNumber)
        {
            TextView incredible = (TextView) findViewById(R.id.incredible);
            incredible.setVisibility(View.VISIBLE);
        }

        getSupportActionBar();

        TextView finalScore = (TextView) findViewById(R.id.final_score);
        String scoreText = String.valueOf(n) + "/" + questionNumber;
        finalScore.setText(scoreText);
    }

    /**
     * If user want to go back he'll go to MainActivity
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Handle app bar button action
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_button:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    /**
     * Create new quiz/refresh button
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_button, menu);
        return true;
    }
}
