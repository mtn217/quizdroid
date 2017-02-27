package edu.washington.mtn217.quizdroid;

import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 */
public class DownloadService extends IntentService {
    DownloadManager manager;
    private static String url = "http://tednewardsandbox.site44.com/questions.json";
    private static int mins = 5;
    private SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        url = sharedPrefs.getString("URL", "http://tednewardsandbox.site44.com/questions.json");
        mins = sharedPrefs.getInt("TIME", 5);

        Toast.makeText(getApplicationContext(), "Downloading JSON file from " + url, Toast.LENGTH_SHORT).show();
        manager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        //long downloadFile = manager.enqueue(request);
    }

    public static void startOrStopAlarm(Context context, boolean on) {
        Log.i("DownloadService", "startOrStopAlarm on = " + on);

        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        url = context.getSharedPreferences("preferences.xml", 0).getString("URL", "questions.json");

        if (on) {
            int time = Integer.parseInt(context.getSharedPreferences("preferences.xml", 0).getString("TIME", "5"));
            int refreshInterval = time * 60000;
            // Try mins here too

            Log.i("DownloadService", "setting alarm to " + refreshInterval);

            manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), refreshInterval, pendingIntent);

        } else {
            manager.cancel(pendingIntent);
            pendingIntent.cancel();

            Log.i("DownloadService", "Stopping alarm");
        }
    }
}
