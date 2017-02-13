package edu.washington.mtn217.quizdroid;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.JsonToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
    }

//
//        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
//
//        // use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        mRecyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//        // specify an adapter (see also next example)
//        mAdapter = new MyAdapter(myDataset);
//        mRecyclerView.setAdapter(mAdapter);


//    public ArrayList<String> readJsonStream(InputStream in) throws IOException {
//        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
//        try {
//            return readMessagesArray(reader);
//        } finally {
//            reader.close();
//        }
//    }
//
//
//    public ArrayList<String> readMessagesArray(JsonReader reader) throws IOException {
//        ArrayList<String> topics = new ArrayList<String>();
//
//        reader.beginArray();
//        while (reader.hasNext()) {
//            topics.add(readMessage(reader));
//        }
//        reader.endArray();
//        return topics;
//    }
//
//
//    public String readMessage(JsonReader reader) throws IOException {
//        // title, desc, questions (text, answer, answers)
//        String title = null;
//        String desc = null;
//        ArrayList<String> questions = null; //Maybe map instead
//
////        long id = -1;
////        String text = null;
////        User user = null;
////        List<Double> geo = null;
//
//        reader.beginObject();
//        while (reader.hasNext()) {
//            String name = reader.nextName();
//            if (name.equals("title")) {
//                title = reader.nextString();
//            } else if (name.equals("desc")) {
//                desc = reader.nextString();
//            } else if (name.equals("questions")) {
//                questions = readQuestionArray(reader);
//            } else {
//                reader.skipValue();
//            }
//        }
//        reader.endObject();
//        return "";
//        //return new Message(id, text, user, geo);
//    }
//
//
//    public ArrayList<String> readQuestionArray(JsonReader reader) throws IOException {
//        ArrayList<String> questions = new ArrayList<String>();
//
//        reader.beginArray();
//        while (reader.hasNext()) {
//            //questions.add(reader.nextDouble());
//        }
//        reader.endArray();
//        return questions;
//    }
//
//
//    public User readUser(JsonReader reader) throws IOException {
//        String username = null;
//        int followersCount = -1;
//
//        reader.beginObject();
//        while (reader.hasNext()) {
//            String name = reader.nextName();
//            if (name.equals("name")) {
//                username = reader.nextString();
//            } else if (name.equals("followers_count")) {
//                followersCount = reader.nextInt();
//            } else {
//                reader.skipValue();
//            }
//        }
//        reader.endObject();
//        return new User(username, followersCount);
//    }
}
