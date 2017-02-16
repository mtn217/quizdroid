package edu.washington.mtn217.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private List<Topic> topicList;
    public static final String MESSAGE = "edu.washington.mtn217.quizdroid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        QuizApp quizApp = QuizApp.getInstance();
        TopicRepository repository = quizApp.getRepository();
        topicList = repository.getAllTopics();

        MyAdapter adapter = new MyAdapter(this, topicList);

        ListView quizCategory = (ListView) findViewById(R.id.listView);
        quizCategory.setAdapter(adapter);

        quizCategory.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Topic selectedTopic = topicList.get(position);
                Gson gson = new Gson();
                String json = gson.toJson(selectedTopic);

                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra(MESSAGE, json);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.pref) {
            Intent settingsIntent = new Intent(this, Preferences.class);
            startActivity(settingsIntent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
