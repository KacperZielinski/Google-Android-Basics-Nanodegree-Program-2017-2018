package com.zielinski.kacper.carquiz;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Question with answers class
 */

public class Question
{
    private ArrayList<String> correctAnswers;
    private ArrayList<String> answers;
    private boolean wasShuffled;
    private QuestionType questionType;
    private String question;
    private String imageName;

    public Question()
    {
        questionType = QuestionType.RADIOBUTTON;
        answers = new ArrayList<>();
        correctAnswers = new ArrayList<>();
    }

    /**
     * Get question type
     * @return QuestionType enum
     */
    public QuestionType getQuestionType() {
        return questionType;
    }

    /**
     * Set question type
     * @param questionType QuestionType enum
     */
    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    /**
     * Set question to the Question object
     * @param question question String
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Get question to the Question object
     * @return question String
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Get all possible answers
     * @return ArrayList<String>
     */
    public ArrayList<String> getAnswers() {
        return answers;
    }

    /**
     * Simply add answer
     * @param answer String
     */
    public void addAnswer(String answer)
    {
        answers.add(answer);
    }

    /**
     * Add answer, you can decide if it's true or false
     * @param answer String
     * @param correct boolean
     */
    public void addAnswer(String answer, boolean correct)
    {
        if(correct)
        {
            correctAnswers.add(answer);
        }

        if(correctAnswers.size() > 1)
            questionType = QuestionType.CHECKBOX;

        answers.add(answer);
    }

    /**
     * Checks if answer to the question is true
     * @param proposed answer String
     * @return boolean
     */
    public boolean isCorrect(String proposed)
    {
        if(getQuestionType().equals(QuestionType.CHECKBOX))
            return false;

        return proposed.equals(correctAnswers.get(0));
    }

    /**
     * Checks if answer to the question is true
     * @param proposed answer ArrayList<String>, multiple answer
     * @return boolean
     */
    public boolean isCorrect(ArrayList<String> proposed)
    {
        if(proposed == null)
            return false;

        return proposed.containsAll(correctAnswers) && correctAnswers.containsAll(proposed);
    }

    /**
     * Shuffle an answers array
     */
    public void shuffle()
    {
        Collections.shuffle(answers);
    }

    /**
     * Shuffle an answers array with singleton restriction
     */
    public void shuffleOnce()
    {
        if(!wasShuffled)
            Collections.shuffle(answers);

        wasShuffled = true;
    }

    /**
     * Gives String in type of drawable resource
     * @return String
     */
    public String getImageName()
    {
        return imageName;
    }

    /**
     * Set string like a drawable resource
     * @param imageName String
     */
    public void setImageName(String imageName)
    {
        this.imageName = imageName;
    }
}
