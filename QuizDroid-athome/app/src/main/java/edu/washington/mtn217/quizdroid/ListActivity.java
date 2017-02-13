package edu.washington.mtn217.quizdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    private List<Topic> topicList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        QuizApp quizApp = QuizApp.getInstance();
        TopicRepository repository = quizApp.getRepository();
        topicList = repository.getAllTopics();
        List<String> topics = repository.getTopicNames();


        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(topicList);
        mRecyclerView.setAdapter(mAdapter);


//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, topics);
//        ListView quizCategory = (ListView)findViewById(R.id.category);
//        quizCategory.setAdapter(adapter);
    }
}
