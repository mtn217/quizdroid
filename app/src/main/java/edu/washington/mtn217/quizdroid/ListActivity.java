package edu.washington.mtn217.quizdroid;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;
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

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private List<Topic> topicList;
    public static final String MESSAGE = "edu.washington.mtn217.quizdroid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        if(checkInternetConnection()) {
            QuizApp quizApp = QuizApp.getInstance();
            TopicRepository repository = quizApp.getRepository();
            topicList = repository.getAllTopics();

            MyAdapter adapter = new MyAdapter(this, topicList);

            ListView quizCategory = (ListView) findViewById(R.id.listView);
            quizCategory.setAdapter(adapter);

            TextView msg = (TextView) findViewById(R.id.textView7);
            msg.setVisibility(View.INVISIBLE);

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
        } else {
            if(isAirplaneModeOn(this)) {
                Log.i("QuizApp", "airplane mode");
                // Ask to turn airplane mode off and then take user to Settings activity to do so

                AlertDialog alertBuilder = new AlertDialog.Builder(ListActivity.this).create();
                alertBuilder.setMessage("Do you want to turn airplane mode off to download data for QuizDroid app?");
                alertBuilder.setTitle("No Internet Access");
                alertBuilder.setButton(AlertDialog.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        Intent settings = new Intent(android.provider.Settings.ACTION_SETTINGS);
                        startActivity(settings);
                    }
                });
                alertBuilder.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                alertBuilder.show();

            } else {
                AlertDialog alert = new AlertDialog.Builder(ListActivity.this).create();
                alert.setMessage("You need to be connected to the internet to download the data for QuizDroid app.");
                alert.setTitle("No Internet Access");
                // Add the buttons
                alert.setButton(AlertDialog.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                alert.show();
            }
        }

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

    public boolean checkInternetConnection() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }

    private boolean isFileExists(String filename){
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + filename);
        String la = Environment.getExternalStorageDirectory().getAbsolutePath() + filename;
        return file.exists();
    }

    private boolean deleteFilez(String filename){
        File folder1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + filename);
        return folder1.delete();
    }
}
