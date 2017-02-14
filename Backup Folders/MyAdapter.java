package edu.washington.mtn217.quizdroid;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import edu.washington.mtn217.quizdroid.R;

/**
 * Created by Michael on 2/7/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Topic> mDataset;

    public MyAdapter(List<Topic> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Topic currTopic = mDataset.get(position);
        final String topic = currTopic.getTitle();
        final int positionTopic = position;
        String descr = currTopic.getShortDescr();
        holder.topic.setText(topic);
        holder.descr.setText(descr);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), topic, Toast.LENGTH_SHORT).show();
//
//                if(positionTopic == 0) {
//                    Intent intent = new Intent(ListActivity, MainActivity.class);
//                    //intent.putExtra(MESSAGE, "0");
//                    //startActivity(intent);
//                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView topic;
        public TextView descr;
        public Button button;
        public ViewHolder(View v) {
            super(v);
            topic = (TextView) v.findViewById(R.id.textView3);
            descr = (TextView) v.findViewById(R.id.textview5);
            button = (Button) v.findViewById(R.id.button);
        }
    }
}
