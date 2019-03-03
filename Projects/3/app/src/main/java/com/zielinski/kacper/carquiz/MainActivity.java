package com.zielinski.kacper.carquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Starts application, welcome screen
 */
public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            getSupportActionBar().hide();
        }
        catch(NullPointerException e)
        {
            Log.e("Bar hide won't work", "It's only null pointer");
        }
    }

    /**
     * Activates onClick of the Button
     * It start the quiz, create first question activity
     * @param view Button view
     */
    public void startQuiz(View view)
    {
        Runnable loadQuestions = () -> {
            QuizQuestions.add();
            QuizQuestions.shuffle();
        };

        Thread loadQuestionThread = new Thread(loadQuestions);
        loadQuestionThread.start();

        try
        {
            //TODO some progressbar ?
            loadQuestionThread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        Intent secondActivity = new Intent(this, SecondActivity.class);
        secondActivity.putExtra("questionID", 0);
        secondActivity.putExtra("score", 0);
        finish();
        startActivity(secondActivity);
    }

    /**
     * If user want to go back he'll go exit
     */
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
