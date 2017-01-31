package com.example.iguest.intactfrag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);


        Intent i = getIntent();
        String message = i.getStringExtra(MainActivity.MESSAGE);

        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(message);
    }
}
