package edu.washington.mtn217.quizdroid;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.washington.mtn217.quizdroid.R;

/**
 * Created by Michael on 2/12/2017.
 */

public class QuizApp extends Application {
    private static final String TAG = "QuizApp";
    private static QuizApp instance = new QuizApp();
    private TopicRepository topicsRepository;
    private String mathTitle, mathShort, mathLong, marvelTitle, marvelShort, marvelLong, scienceLong,
                    scienceShort, scienceTitle;

    public static QuizApp getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        topicsRepository = new HardCodedRepository();

        mathTitle = "Mathematics";
        mathShort = "Did you pass the third grade?";
        mathLong = "Did you pass the third grade? This topic has 1 question.";

        String mathOne = "What is 2+2 ?";
        String mathOneAns = "4";
        String mathOneAnsTwo = "22";
        String mathOneAnsThree = "An irrational number";
        String mathOneAnsFour = "Nobody knows";
        int mathCorrect = 1;
        Question mathOneQ = new Question(mathOne, mathOneAns, mathOneAnsTwo, mathOneAnsThree, mathOneAnsFour, mathCorrect);

        List<Question> allMath = new ArrayList<Question>();
        allMath.add(mathOneQ);
        setup(mathTitle, mathShort, mathLong, allMath);



        marvelTitle = "Marvel Super Heroes";
        marvelShort = "Avengers, Assemble!";
        marvelLong = "Avengers, Assemble! This section has 2 questions";

        String marvelOne = "Who is Iron Man?";
        String marvelAnsOne = "Tony Stark";
        String marvelAnsTwo = "Obadiah Stane";
        String marvelAnsThree = "A rock hit by Megadeth";
        String marvelAnsFour = "Nobody knows";
        int marvelCorrect = 1;
        Question marvelOneQ = new Question(marvelOne, marvelAnsOne, marvelAnsTwo, marvelAnsThree, marvelAnsFour, marvelCorrect);

        String marvelTwo = "Who founded the X-Men?";
        String marvelTwoAnsOne = "Professor X";
        String marvelTwoAnsTwo = "Tony Stark";
        String marvelTwoAnsThree = "The X-Institute";
        String marvelTwoAnsFour = "Erik Lensherr";
        int marvelTwoCorrect = 2;
        Question marvelTwoQ = new Question(marvelTwo, marvelTwoAnsOne, marvelTwoAnsTwo, marvelTwoAnsThree, marvelTwoAnsFour, marvelTwoCorrect);

        List<Question> allMarvel = new ArrayList<Question>();
        allMarvel.add(marvelOneQ);
        allMarvel.add(marvelTwoQ);
        setup(marvelTitle, marvelShort, marvelLong, allMarvel);



        scienceTitle = "Science!";
        scienceShort = "Because SCIENCE!";
        scienceLong = "Because SCIENCE! This topic has 1 question.";
        String scienceOne = "What is fire?";

        String scienceAnsOne = "One of the four classical elements";
        String scienceAnsTwo = "A magical reaction given to us by God";
        String scienceAnsThree = "A band that hasn't yet been discovered";
        String scienceAnsFour = "Fire! Fire! Fire! heh-heh";
        int scienceCorrect = 1;
        Question scienceQ = new Question(scienceOne, scienceAnsOne, scienceAnsTwo, scienceAnsThree, scienceAnsFour, scienceCorrect);

        List<Question> allScience = new ArrayList<Question>();
        allScience.add(scienceQ);
        setup(scienceTitle, scienceShort, scienceLong, allScience);
    }

//    public void setupTopic(String title, String shortDescr, String longDescr, List<String> questions, List<String> answers, int correctAns) {
//        List<Question> allQuestions = new ArrayList<Question>();
//        for (String curr : questions) {
//            Question currQuestion = new Question();
//            currQuestion.setQuestion(curr);
//            int count = 0;
//            while (count < 4) {
//                String currAns = answers.get(count);
//                if (count == 0) {
//                    currQuestion.setAnsOne(currAns);
//                } else if (count == 1) {
//                    currQuestion.setAnsTwo(currAns);
//                } else if (count == 2) {
//                    currQuestion.setAnsThree(currAns);
//                } else {
//                    currQuestion.setAnsFour(currAns);
//                }
//                count++;
//            }
//            currQuestion.setCorrectAns(correctAns);
//            allQuestions.add(currQuestion);
//        }
//
//        //Create new topic
//        Topic currentTopic = new Topic(title, shortDescr, longDescr, allQuestions);
//
//        topicsRepository.addTopic(currentTopic);
//    }

    public TopicRepository getRepository() {
        if (topicsRepository == null) {
            topicsRepository = HardCodedRepository.getInstance();
        }
        return topicsRepository;
    }

    public void setup(String title, String shortDescr, String longDescr, List<Question> questions) {
        Topic currentTopic = new Topic(title, shortDescr, longDescr, questions);
        topicsRepository.addTopic(currentTopic);
    }
}