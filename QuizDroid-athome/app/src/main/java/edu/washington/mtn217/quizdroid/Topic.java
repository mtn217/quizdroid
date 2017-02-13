package edu.washington.mtn217.quizdroid;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Michael on 2/12/2017.
 */

public class Topic implements Serializable {
    private String title, shortDescr, longDescr;
    private List<Question> questions;

    public String getTitle() {
        return title;
    }

    public String getShortDescr() {
        return shortDescr;
    }

    public String getLongDescr() {
        return longDescr;
    }

    public List<Question> getAllQuestions() {
        return questions;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortDescr(String shortDescr) {
        this.shortDescr = shortDescr;
    }

    public void setLongDescr(String longDescr) {
        this.longDescr = longDescr;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Topic (String title, String shortDescr, String longDescr, List<Question> questions) {
        setTitle(title);
        setShortDescr(shortDescr);
        setLongDescr(longDescr);
        setQuestions(questions);
    }
}
