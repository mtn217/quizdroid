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
    private List<String> mathQuestion, marvelQuestion, scienceQuestion, mathAns, marvelAns, scienceAns;
    private int marvelCorrect, scienceCorrect;


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
        mathLong = "Did you pass the third grade?";

        String mathOne = "What is 2+2?";
        String mathOneAns = "4";
        String mathOneAnsTwo = "22";
        String mathOneAnsThree = "An irrational number";
        String mathOneAnsFour = "Nobody knows";
        int mathCorrect = 1;
        Question mathOneQ = new Question(mathOne, mathOneAns, mathOneAnsTwo, mathOneAnsThree, mathOneAnsFour, mathCorrect);

        List<Question> allMath = new ArrayList<Question>();
        allMath.add(mathOneQ);
        Topic math = new Topic(mathTitle, mathShort, mathLong, allMath);
        topicsRepository.addTopic(math);


        mathQuestion = new ArrayList<String>();
        mathQuestion.add("What is 2+2?");
        mathAns = new ArrayList<String>();
        mathAns.add("4");
        mathAns.add("22");
        mathAns.add("An irrational number");
        mathAns.add("Nobody knows");
        //mathCorrect = 1;
        //Set up all the questions and answers for math
        setupTopic(mathTitle, mathLong, mathShort, mathQuestion, mathAns, mathCorrect);


        marvelTitle = "Marvel Super Heroes";
        marvelShort = "Avengers, Assemble!";
        marvelLong = "Avengers, Assemble!";

        marvelQuestion = new ArrayList<String>();
        marvelQuestion.add("Who is Iron Man?");
        marvelAns = new ArrayList<String>();
        marvelAns.add("Tony Stark");
        marvelAns.add("Obadiah Stane");
        marvelAns.add("A rock hit by Megadeth");
        marvelAns.add("Nobody knows");
        marvelCorrect = 1;
        //Create Question object

        //List<String> scienceQuestionTwo = new ArrayList<String>();
//        scienceQuestion.add("Who founded the X-Men?");
//
//        List<String> scienceAnsTwo = new ArrayList<String>();
//        scienceAnsTwo.add("Professor X");
//        scienceAnsTwo.add("Tony Stark");
//        scienceAnsTwo.add("The X-Institute");
//        scienceAnsTwo.add("Erik Lensherr");
//        int scienceCorrectTwo = 2;
        //Create other Question object

        //Create Topic object with the question objects

        //Set up all the questions and answers for marvel
        setupTopic(marvelTitle, marvelLong, marvelShort, marvelQuestion, marvelAns, marvelCorrect);


        scienceTitle = "Science!";
        scienceShort = "Because SCIENCE!";
        scienceLong = "Because SCIENCE! This topic has 2 questions.";
        String scienceQ = "What is fire?";
        scienceAns = new ArrayList<String>();
        scienceAns.add("One of the four classical elements");
        scienceAns.add("A magical reaction given to us by God");
        scienceAns.add("A band that hasn't yet been discovered");
        scienceAns.add("Fire! Fire! Fire! heh-heh");
        scienceCorrect = 1;
        //Question scienceOne = new Question();
        //scienceOne.setAnsOne();
        //scienceOne.setAnsTwo();
        //scienceOne.setAnsThree();
        //scienceOne.setAnsFour();
        //scienceOne.setCorrect(scienceCorrect);

//        scienceQuestion = new ArrayList<String>();
//        scienceQuestion.add("What is fire?");

//        scienceAnsOne = new ArrayList<String>();
//        scienceAnsOne.add("One of the four classical elements");
//        scienceAnsOne.add("A magical reaction given to us by God");
//        scienceAnsOne.add("A band that hasn't yet been discovered");
//        scienceAnsOne.add("Fire! Fire! Fire! heh-heh");
//        scienceCorrect = 1;

        //Set up all the questions and answers for science
        setupTopic(scienceTitle, scienceLong, scienceShort, scienceQuestion, scienceAns, scienceCorrect);
    }

    public void setupTopic(String title, String shortDescr, String longDescr, List<String> questions, List<String> answers, int correctAns) {
        List<Question> allQuestions = new ArrayList<Question>();
        for (String curr : questions) {
            Question currQuestion = new Question();
            currQuestion.setQuestion(curr);
            int count = 0;
            while (count < 4) {
                String currAns = answers.get(count);
                if (count == 0) {
                    currQuestion.setAnsOne(currAns);
                } else if (count == 1) {
                    currQuestion.setAnsTwo(currAns);
                } else if (count == 2) {
                    currQuestion.setAnsThree(currAns);
                } else {
                    currQuestion.setAnsFour(currAns);
                }
                count++;
            }
            currQuestion.setCorrectAns(correctAns);
            allQuestions.add(currQuestion);
        }

        //Create new topic
        Topic currentTopic = new Topic(title, shortDescr, longDescr, allQuestions);

        topicsRepository.addTopic(currentTopic);
    }

    public TopicRepository getRepository() {
        if (topicsRepository == null) {
            topicsRepository = HardCodedRepository.getInstance();
        }
        return topicsRepository;
    }
}


/*
[
    { "title":"Science!",
      "desc":"Because SCIENCE!",
      "questions":[
        {
          "text":"What is fire?",
          "answer":"1",
          "answers":[
            "One of the four classical elements",
            "A magical reaction given to us by God",
            "A band that hasn't yet been discovered",
            "Fire! Fire! Fire! heh-heh"
          ]
        }
      ]
    },
    { "title":"Marvel Super Heroes",
      "desc": "Avengers, Assemble!",
      "questions":[
        {
          "text":"Who is Iron Man?",
          "answer":"1",
          "answers":[
            "Tony Stark",
            "Obadiah Stane",
            "A rock hit by Megadeth",
            "Nobody knows"
          ]
        },
        {
          "text":"Who founded the X-Men?",
          "answer":"2",
          "answers":[
            "Tony Stark",
            "Professor X",
            "The X-Institute",
            "Erik Lensherr"
          ]
        },
        {
          "text":"How did Spider-Man get his powers?",
          "answer":"1",
          "answers":[
            "He was bitten by a radioactive spider",
            "He ate a radioactive spider",
            "He is a radioactive spider",
            "He looked at a radioactive spider"
          ]
        }
      ]
    },
    { "title":"Mathematics",
      "desc":"Did you pass the third grade?",
      "questions":[
         {
           "text":"What is 2+2?",
           "answer":"1",
           "answers":[
             "4",
             "22",
             "An irrational number",
             "Nobody knows"
           ]
         }
      ]
   }
]

 */
