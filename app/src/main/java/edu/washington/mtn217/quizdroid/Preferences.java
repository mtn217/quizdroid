package edu.washington.mtn217.quizdroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Boolean.FALSE;

public class Preferences extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String URL_NAME = "URL";
    public static final String INTERVAL_NAME = "TIME";
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals(URL_NAME)) {
            url = sharedPreferences.getString(key, "http://tednewardsandbox.site44.com/questions.json");
//            Log.i("Test", url);
//            Toast.makeText(getApplicationContext(), "Updated URL to " + url, Toast.LENGTH_LONG).show();
        } else if (key.equals(INTERVAL_NAME)){
            String interval = sharedPreferences.getString(key, "0");
            int result = Integer.parseInt(interval);
//            Log.i("Test", "" + result);
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
