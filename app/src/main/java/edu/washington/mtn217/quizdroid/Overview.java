package edu.washington.mtn217.quizdroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Overview extends Fragment implements View.OnClickListener {
    // start button
    private Topic currTopic;
    private String title;
    private String longDescr;
    private List<Question> questions;
    Fragment questionFrag;

    public Overview() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        Intent intent = getActivity().getIntent();
        String json = (String)intent.getSerializableExtra(ListActivity.MESSAGE);

        Gson gson = new Gson();
        currTopic = gson.fromJson(json, Topic.class);
        title = currTopic.getTitle();
        longDescr = currTopic.getLongDescr();
        //questions = currTopic.getAllQuestions();

        TextView titleTx = (TextView) view.findViewById(R.id.textView8);
        TextView descrTx = (TextView) view.findViewById(R.id.textView4);

        titleTx.setText(title);
        descrTx.setText(longDescr);

        Button start = (Button) view.findViewById(R.id.button);
        start.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        questionFrag = new QuestionFrag();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_placeholder, questionFrag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
