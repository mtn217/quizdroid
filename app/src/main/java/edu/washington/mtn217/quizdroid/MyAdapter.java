package edu.washington.mtn217.quizdroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.washington.mtn217.quizdroid.R;

/**
 * Created by Michael on 2/7/2017.
 */

public class MyAdapter extends ArrayAdapter<Topic> {

    public MyAdapter(Context context, List<Topic> topics) {
        super(context, 0, topics);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Topic currTopic = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_list_item, parent, false);
        }
        // Lookup view for data population
        TextView topic = (TextView) convertView.findViewById(R.id.textView3);
        TextView descr = (TextView) convertView.findViewById(R.id.textview5);
        // Populate the data into the template view using the data object
        String title = currTopic.getTitle();
        String descrz = currTopic.getShortDescr();
        topic.setText(title);
        descr.setText(descrz);



        // Return the completed view to render on screen
        return convertView;
    }
}
