package edu.washington.mtn217.quizdroid;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static android.content.Context.DOWNLOAD_SERVICE;

public class AlarmReceiver extends BroadcastReceiver {
    private DownloadManager downloadManager;
    private long downloadReference;

    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String url = sharedPref.getString("URL", "http://tednewardsandbox.site44.com/questions.json");
        Toast.makeText(context, "Downloading JSON file from " + url, Toast.LENGTH_LONG).show();

        downloadManager = (DownloadManager) context.getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, "questions.json");
        downloadReference = downloadManager.enqueue(request);


        IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        context.getApplicationContext().registerReceiver(downloadReceiver, filter);

    }

    private BroadcastReceiver downloadReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(final Context context, Intent intent) {
        int character;
        ParcelFileDescriptor file;
        StringBuffer str = new StringBuffer("");

        try {
            file = downloadManager.openDownloadedFile(downloadReference);
            FileInputStream fileInputStream = new ParcelFileDescriptor.AutoCloseInputStream(file);
            while( (character = fileInputStream.read()) != -1)
                str.append((char)character);

            JSONArray data = new JSONArray(str.toString());

            QuizApp quizApp = (QuizApp) context.getApplicationContext();
            quizApp.createTopicsJson(data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        }
    };
}
