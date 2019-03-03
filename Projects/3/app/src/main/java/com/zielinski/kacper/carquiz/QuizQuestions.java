package com.zielinski.kacper.carquiz;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Cheated database :)
 */

final public class QuizQuestions
{
    /**
     * Only one array with question (Singleton)
     */
    private static ArrayList<Question> questions = new ArrayList<>();
    private static boolean areAdded;
    private static int size;
    private QuizQuestions() { }

    /**
     * Add questions to array
     */
    public static void add()
    {
        if(!areAdded)
        {
            Question q1 = new Question();
            q1.setQuestion("What is it?");
            q1.addAnswer("Spark plug", true);
            q1.addAnswer("Carburettor");
            q1.addAnswer("Ignition coil");
            q1.addAnswer("Ignition wires");
            q1.setImageName("spark_plug");
            questions.add(q1);

            Question q2 = new Question();
            q2.setQuestion("What is it?");
            q2.addAnswer("Crankshaft", true);
            q2.addAnswer("Transmission shaft");
            q2.addAnswer("Half-shaft");
            q2.addAnswer("Stabilizer");
            q2.setImageName("crankshaft");
            questions.add(q2);

            Question q3 = new Question();
            q3.setQuestion("What is it?");
            q3.addAnswer("Diesel injector", true);
            q3.addAnswer("Ignition coil");
            q3.addAnswer("Muffler");
            q3.addAnswer("Alternator");
            q3.setImageName("diesel_injector");
            questions.add(q3);

            Question q4 = new Question();
            q4.setQuestion("What is it?");
            q4.addAnswer("Half-shaft", true);
            q4.addAnswer("Crankshaft");
            q4.addAnswer("Transmission shaft");
            q4.addAnswer("Wheel hub");
            q4.setImageName("half_shaft");
            questions.add(q4);

            Question q5 = new Question();
            q5.setQuestion("What is it?");
            q5.addAnswer("Turbocharger", true);
            q5.addAnswer("Piston");
            q5.addAnswer("Head gasket");
            q5.addAnswer("Thermostat");
            q5.setImageName("turbo");
            questions.add(q5);

            Question q6 = new Question();
            q6.setQuestion("What can mean blue smoke from the exhaust pipe?");
            q6.addAnswer("Engine oil combustion", true);
            q6.addAnswer("Diesel oil combustion");
            q6.addAnswer("Coolant combustion");
            q6.addAnswer("Fuel leak");
            questions.add(q6);

            Question q7 = new Question();
            q7.setQuestion("What is not part of the engine?");
            q7.addAnswer("Gearbox", true);
            q7.addAnswer("Exhaust pipe", true);
            q7.addAnswer("Piston");
            q7.addAnswer("Head gasket");
            q7.setQuestionType(QuestionType.CHECKBOX);
            questions.add(q7);

            Question q8 = new Question();
            q8.setQuestion("Which of the given below oils provides the easiest start-up?");
            q8.addAnswer("0W40", true);
            q8.addAnswer("5W40");
            q8.addAnswer("10W40");
            q8.addAnswer("15W40");
            questions.add(q8);

            Question q9 = new Question();
            q9.setQuestion("You have an 4 cylinder Alfa Romeo TwinSpark engine. How many spark plugs do you need if you want to replace all?");
            q9.addAnswer("8", true);
            q9.setQuestionType(QuestionType.EDITTEXT);
            questions.add(q9);

            Question q10 = new Question();
            q10.setQuestion("Which of the given below filters does not exist?");
            q10.addAnswer("Piston filter", true);
            q10.addAnswer("Oil filter");
            q10.addAnswer("Fuel filter");
            q10.addAnswer("Air filter");
            questions.add(q10);

//            Question q11 = new Question();
//            q11.setQuestion("What is true about Kacper's car?");
//            q11.addAnswer("It's LPG", true);
//            q11.addAnswer("It's 138PS", true);
//            q11.addAnswer("It's awesome!", true);
//            q11.addAnswer("It's Peugeot 406 Coupe D9 version", true);
//            q11.setQuestionType(QuestionType.CHECKBOX);
//            questions.add(q11);

            areAdded = true;
            size = questions.size();
        }
    }

    /**
     * Clear an array
     */
    public static void remove()
    {
        areAdded = false;
        questions.clear();
    }

    /**
     * Shuffle order of questions
     */
    public static void shuffle()
    {
        Collections.shuffle(questions);
    }

    /**
     * Get questions array method
     * @return array of Question objects
     */
    public static ArrayList<Question> getQuestions()
    {
        return questions;
    }

    public static int getSize()
    {
        return size;
    }
}
