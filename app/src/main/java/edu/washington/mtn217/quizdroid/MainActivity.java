package edu.washington.mtn217.quizdroid;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Message;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import android.os.Environment;

public class MainActivity extends AppCompatActivity {
    private int answered;
    private int correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isExternalStorageWritable()) {
            Log.i("MainActivity", "File root: " + android.os.Environment.getExternalStorageDirectory().getAbsolutePath());
        }


        answered = 0;
        correct = 0;
        Intent intent = getIntent();
        String json = (String)intent.getSerializableExtra(ListActivity.MESSAGE);

        Gson gson = new Gson();
        Topic chosenTopic = gson.fromJson(json, Topic.class);

        Fragment fragToDisplay = new Overview();

        FragmentTransaction tx = getFragmentManager().beginTransaction();
        tx.replace(R.id.fragment_placeholder, fragToDisplay);
        tx.commit();
    }

    public int getPosition() {
        return answered;
    }

    public int getCorrect() {
        return correct;
    }

    public void addAnswered() {
        answered++;
    }

    public void addCorrect() {
        correct++;
    }


    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
}
