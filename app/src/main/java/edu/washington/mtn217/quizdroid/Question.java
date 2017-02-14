package edu.washington.mtn217.quizdroid;

/**
 * Created by Michael on 2/12/2017.
 */

public class Question {
    private String question, ansOne, ansTwo, ansThree, ansFour;
    private int correct;

    public Question() {

    }

    public Question (String question, String ansOne, String ansTwo, String ansThree, String ansFour, int correct) {
        setQuestion(question);
        setAnsOne(ansOne);
        setAnsTwo(ansTwo);
        setAnsThree(ansThree);
        setAnsFour(ansFour);
        setCorrectAns(correct);
    }

    public String getQuestion() {
        return question;
    }

    public String getAnsOne() {
        return ansOne;
    }

    public String getAnsTwo() {
        return ansTwo;
    }

    public String getAnsThree() {
        return ansThree;
    }

    public String getAnsFour() {
        return ansFour;
    }

    public int getCorrectAns() {
        return correct;
    }

    public void setAnsOne(String ansOne) {
        this.ansOne = ansOne;
    }

    public void setAnsTwo(String ansTwo) {
        this.ansTwo = ansTwo;
    }

    public void setAnsThree(String ansThree) {
        this.ansThree = ansThree;
    }

    public void setAnsFour(String ansFour) { this.ansFour = ansFour; }

    public void setCorrectAns(int correct) {
        this.correct = correct;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
