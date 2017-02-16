package edu.washington.mtn217.quizdroid;

import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Preferences extends PreferenceActivity {
    private TextView currURL;
    private TextView currTime;
    private EditText url;
    private EditText time;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        addPreferencesFromResource(R.xml.preferences);

    }
}

//        toast = Toast.makeText(getApplicationContext(), "Changes Saved", Toast.LENGTH_SHORT);
//
//        url = (EditText) findViewById(R.id.editText);
//        time = (EditText) findViewById(R.id.editText3);
//
//        currURL = (TextView) findViewById(R.id.textView10); //Set this to whatever preference is!
//        currTime = (TextView) findViewById(R.id.textView11); //Set this to whatever preference is!
//
//        Button save = (Button) findViewById(R.id.button3);
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!url.getText().toString().equals("")) {
//                    String newURL = url.getText().toString();
//                    currURL.setText("Current URL:\n" + newURL);
//                }
//
//                if(!time.getText().toString().equals("")) {
//                    String newTime = time.getText().toString();
//                    currTime.setText("Current Download Check:\n" + newTime + "minutes");
//                }
//                toast.show();
//            }
//        });
