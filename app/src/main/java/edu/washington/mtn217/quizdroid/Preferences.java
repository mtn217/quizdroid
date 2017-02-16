package edu.washington.mtn217.quizdroid;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Preferences extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String PREFS_NAME = "URL";
    private Toast toast;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals(PREFS_NAME)) {
            Preference p = findPreference(key);
            Log.i("Test", "hi it worksbeeepboop!!!!!");
            url = sharedPreferences.getString(key, "");
            toast = Toast.makeText(getApplicationContext(), "Updated URL to " + url, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
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
