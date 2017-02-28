package edu.washington.mtn217.quizdroid;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Michael on 2/27/2017.
 */

public class DownloadReceiver extends BroadcastReceiver {
    private DownloadManager downloadManager;
    private long downloadReference;

    public DownloadReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("DownloadReceiver", "entered onReceive() from DownloadReceiver");

    }
}
