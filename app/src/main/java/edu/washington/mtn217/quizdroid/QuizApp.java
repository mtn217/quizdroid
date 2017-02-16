package edu.washington.mtn217.quizdroid;

import android.app.Application;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.JsonReader;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.InflaterInputStream;

import android.content.Context;

import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.washington.mtn217.quizdroid.R;

/**
 * Created by Michael on 2/12/2017.
 */

public class QuizApp extends Application {
    private static final String TAG = "QuizApp";
    private static QuizApp instance = new QuizApp();
    private TopicRepository topicsRepository;
    private InflaterInputStream stream;

    public static QuizApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        topicsRepository = new HardCodedRepository();

        String test = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.i("location", test);
        String json = null;
        try {
            InputStream inputStream = getAssets().open("questions.json");
            json = readJSONFile(inputStream);
            JSONArray data = new JSONArray(json);
            createTopicsJson(data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String readJSONFile(InputStream fis) throws IOException {
        int size = fis.available();
        byte[] buffer = new byte[size];
        fis.read(buffer);
        fis.close();
        return new String(buffer, "UTF-8");
    }

    public void createTopicsJson(JSONArray data) {
        try {
            for (int i = 0; i < data.length(); i++) {
                //Log.i("data", data.get(i).toString());
                JSONObject topicData = (JSONObject) data.get(i);


                String title = topicData.getString("title");
                String descr = topicData.getString("desc");

                JSONArray allQuestions = topicData.getJSONArray("questions");
                //Log.i("question", allQuestions.toString());
                ArrayList<Question> questions = new ArrayList<Question>();
                for (int j = 0; j < allQuestions.length(); j++) {
                    JSONObject question = (JSONObject) allQuestions.get(j);
                    //Log.i("data", question.toString());
                    String questionTxt = question.getString("text");
                    int answer = question.getInt("answer");
                    JSONArray answers = question.getJSONArray("answers");
                    String ansOne = answers.get(0).toString();
                    String ansTwo = answers.get(1).toString();
                    String ansThree = answers.get(2).toString();
                    String ansFour = answers.get(3).toString();
                    questions.add(new Question(questionTxt, ansOne, ansTwo, ansThree, ansFour, answer));
                }
                setup(title, descr, descr, questions);
            }

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

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



//  context = this.getApplicationContext();
//        String filePath = context.getFilesDir() + "/" + "questions.json";
//        Log.i("ListActivity", filePath);
//        File jsonFile = new File(filePath);
//
////        FileInputStream fis = openFileInput(jsonFile);
////        JsonReader jsonReader = new JsonReader(new InputStreamReader(fis));
////        ArrayList<Topic> topicsList = JsonParser.readJson(jsonReader);
////        topicsRepository.addAlltopics(topicsList);
////        jsonReader.close();
////        fis.close();
