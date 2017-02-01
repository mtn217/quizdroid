package edu.washington.mtn217.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    private String[] topics = new String[] {
            "Math", "Physics", "Marvel Super Heroes"
    };

    public static final String MESSAGE = "edu.washington.mtn217.message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, topics);

        ListView quizCategory = (ListView)findViewById(R.id.category);
        quizCategory.setAdapter(adapter);

        quizCategory = (ListView) findViewById(R.id.category);
        quizCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(ListActivity.this, MainActivity.class);
                    intent.putExtra(MESSAGE, "0");
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(ListActivity.this, MainActivity.class);
                    intent.putExtra(MESSAGE, "1");
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(ListActivity.this, MainActivity.class);
                    intent.putExtra(MESSAGE, "2");
                    startActivity(intent);
                }
            }
        });
    }
}
