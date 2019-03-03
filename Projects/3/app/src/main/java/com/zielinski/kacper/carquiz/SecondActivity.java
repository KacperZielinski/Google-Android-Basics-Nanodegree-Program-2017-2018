package com.zielinski.kacper.carquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


/**
 * Activity which shows one of the question
 */
public class SecondActivity extends AppCompatActivity {

    private int questionID = 0;
    private int score = 0;
    private String myAnswer;
    private ArrayList<String> myAnswerList;
    private Question quizQuestion;
    private QuestionType questionType;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        questionID = intent.getIntExtra("questionID", 0);
        score = intent.getIntExtra("score", 0);
        quizQuestion = QuizQuestions.getQuestions().get(questionID);
        questionType = quizQuestion.getQuestionType();

        getSupportActionBar();
        showQuestion();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putString("myAnswer", myAnswer);
        savedInstanceState.putStringArrayList("myAnswerList", myAnswerList);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

        myAnswer = savedInstanceState.getString("myAnswer");
        myAnswerList = savedInstanceState.getStringArrayList("myAnswerList");
    }

    /**
     * Show question depended on the type of question
     */
    public void showQuestion()
    {
        LinearLayout checkBoxGroup = (LinearLayout) findViewById(R.id.checkbox_group);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        Button okButton = (Button) findViewById(R.id.ok_button);

        okButton.setBackgroundResource(android.R.drawable.btn_default);

        switch (questionType)
        {
            case RADIOBUTTON:
            {
                checkBoxGroup.setVisibility(View.GONE);
                radioGroup.setVisibility(View.VISIBLE);
                editText.setVisibility(View.GONE);
                showRadioQuestion();
                break;
            }
            case CHECKBOX:
            {
                checkBoxGroup.setVisibility(View.VISIBLE);
                radioGroup.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                showCheckBoxQuestion();
                break;
            }
            case EDITTEXT:
            {
                checkBoxGroup.setVisibility(View.GONE);
                radioGroup.setVisibility(View.GONE);
                editText.setVisibility(View.VISIBLE);
                showEditTextQuestion();
                break;
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(() -> okButton.setOnClickListener(this::anotherQuestion), 700);
    }

    /**
     * Activates onClick of the RadioButton
     * @param view RadioButton view
     */
    public void onRadioButtonClicked(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId())
        {
            case R.id.radio_answer1:
            {
                if(checked)
                    myAnswer = quizQuestion.getAnswers().get(0);
                break;
            }
            case R.id.radio_answer2:
            {
                if(checked)
                    myAnswer = quizQuestion.getAnswers().get(1);
                break;
            }
            case R.id.radio_answer3:
            {
                if(checked)
                    myAnswer = quizQuestion.getAnswers().get(2);
                break;
            }
            case R.id.radio_answer4:
            {
                if(checked)
                    myAnswer = quizQuestion.getAnswers().get(3);
                break;
            }
        }
    }

    /**
     * Activates onClick of the CheckBox
     * @param view CheckBox view
     */
    public void onCheckboxClicked(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkbox_answer1:
            {
                if(checked)
                    myAnswerList.add(quizQuestion.getAnswers().get(0));
                else
                    myAnswerList.remove(quizQuestion.getAnswers().get(0));

                break;
            }
            case R.id.checkbox_answer2:
            {
                if (checked)
                    myAnswerList.add(quizQuestion.getAnswers().get(1));
                else
                    myAnswerList.remove(quizQuestion.getAnswers().get(1));

                break;
            }
            case R.id.checkbox_answer3:
            {
                if (checked)
                    myAnswerList.add(quizQuestion.getAnswers().get(2));
                else
                    myAnswerList.remove(quizQuestion.getAnswers().get(2));

                break;
            }
            case R.id.checkbox_answer4:
            {
                if (checked)
                    myAnswerList.add(quizQuestion.getAnswers().get(3));
                else
                    myAnswerList.remove(quizQuestion.getAnswers().get(3));

                break;
            }
        }
    }

    /**
     * Activates onClick of the "OK" Button
     * Creates next activity with another question or ends quiz
     * @param view Button view
     */
    public void anotherQuestion(View view)
    {
        int questionListSize = QuizQuestions.getQuestions().size();
        questionID++;

        if(quizQuestion.getQuestionType().equals(QuestionType.EDITTEXT))
        {
            EditText editText = (EditText) findViewById(R.id.edit_text);
            myAnswer = editText.getText().toString();
        }


        if(quizQuestion.getQuestionType().equals(QuestionType.CHECKBOX) && quizQuestion.isCorrect(myAnswerList))
        {
            score++;
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        }
        else if(quizQuestion.isCorrect(myAnswer))
        {
            score++;
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();



        if (questionID == questionListSize)
        {
            Intent scoreIntent = new Intent(getApplicationContext(), ScoreActivity.class);
            scoreIntent.putExtra("score", score);
            startActivity(scoreIntent);
        }
        else if(questionID > questionListSize)
            android.os.Process.killProcess(android.os.Process.myPid());

        else
        {
            Intent nextQuestion = new Intent(this, SecondActivity.class);
            nextQuestion.putExtra("questionID", questionID);
            nextQuestion.putExtra("score", score);
            startActivity(nextQuestion);
        }

        finish();
    }

    /**
     * Loads question to RadioButtons, TextView, ImageView
     * Sets or hides image
     */
    public void showRadioQuestion()
    {
        TextView questionText = findViewById(R.id.question_text);
        ImageView image = findViewById(R.id.image);
        image.setVisibility(View.VISIBLE);
        RadioButton answer1 = findViewById(R.id.radio_answer1);
        RadioButton answer2 = findViewById(R.id.radio_answer2);
        RadioButton answer3 = findViewById(R.id.radio_answer3);
        RadioButton answer4 = findViewById(R.id.radio_answer4);

        int imageID = getResource(this, quizQuestion.getImageName());

        if(imageID != 0)
            image.setImageResource(imageID);
        else
            image.setVisibility(View.GONE);

        quizQuestion.shuffleOnce();

        questionText.setText(quizQuestion.getQuestion());
        answer1.setText(quizQuestion.getAnswers().get(0));
        answer2.setText(quizQuestion.getAnswers().get(1));
        answer3.setText(quizQuestion.getAnswers().get(2));
        answer4.setText(quizQuestion.getAnswers().get(3));

        if(myAnswer == null || myAnswer.isEmpty() || myAnswer.equals(""))
            myAnswer = quizQuestion.getAnswers().get(0);
    }

    /**
     * Loads question to CheckBox, TextView, ImageView
     * Sets or hides image
     */
    public void showCheckBoxQuestion()
    {
        TextView questionText = findViewById(R.id.question_text);
        ImageView image = findViewById(R.id.image);
        image.setVisibility(View.VISIBLE);
        CheckBox answer1 = findViewById(R.id.checkbox_answer1);
        CheckBox answer2 = findViewById(R.id.checkbox_answer2);
        CheckBox answer3 = findViewById(R.id.checkbox_answer3);
        CheckBox answer4 = findViewById(R.id.checkbox_answer4);

        int imageID = getResource(this, quizQuestion.getImageName());

        if(imageID != 0)
            image.setImageResource(imageID);
        else
            image.setVisibility(View.GONE);

        quizQuestion.shuffleOnce();

        questionText.setText(quizQuestion.getQuestion());
        answer1.setText(quizQuestion.getAnswers().get(0));
        answer2.setText(quizQuestion.getAnswers().get(1));
        answer3.setText(quizQuestion.getAnswers().get(2));
        answer4.setText(quizQuestion.getAnswers().get(3));

        myAnswerList = new ArrayList<>();
    }

    /**
     * Loads question TextView, ImageView and wait for user input
     * Sets or hides image
     */
    public void showEditTextQuestion()
    {
        TextView questionText = findViewById(R.id.question_text);
        ImageView image = findViewById(R.id.image);
        image.setVisibility(View.VISIBLE);

        int imageID = getResource(this, quizQuestion.getImageName());

        if(imageID != 0)
            image.setImageResource(imageID);
        else
            image.setVisibility(View.GONE);

        questionText.setText(quizQuestion.getQuestion());

        if(myAnswer == null || myAnswer.isEmpty())
            myAnswer = "";
    }

    /**
     * Gives int of drawable resource
     * @param context this
     * @param name name of drawable item e.g. "turbo" means turbo.jpg in drawable folder
     * @return 0 if name is null, otherwise
     */
    private int getResource(Context context, String name)
    {
        if(name == null)
            return 0;

        return context.getResources().getIdentifier(name, "drawable", "com.zielinski.kacper.carquiz");
    }

    /**
     * If user want to go back he'll go to home
     */
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    /**
     * Handle app bar button action
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
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
