package edu.washington.mtn217.quizdroid;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.internal.Primitives;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Answer extends Fragment implements View.OnClickListener {
    private View view;
    private Topic currTopic;
    private List<Question> questions;
    private int selectedAns;
    private MainActivity activity;
    private Button submit;

    public Answer() {
        // Required empty public constructor
    }

// TO DO: FIX BACK BUTTON ERROR

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_answer, container, false);
        Intent intent = getActivity().getIntent();
        String json = (String)intent.getSerializableExtra(ListActivity.MESSAGE);

        Gson gson = new Gson();
        currTopic = gson.fromJson(json, Topic.class);
        questions = currTopic.getAllQuestions();

        activity = (MainActivity) getActivity();
        final Question currQuestion = questions.get(activity.getPosition());
        TextView question = (TextView) view.findViewById(R.id.textView5);
        question.setText(currQuestion.getQuestion());

        RadioButton ansOne = (RadioButton) view.findViewById(R.id.radioButton8);
        ansOne.setText(currQuestion.getAnsOne());

        RadioButton ansTwo = (RadioButton) view.findViewById(R.id.radioButton7);
        ansTwo.setText(currQuestion.getAnsTwo());

        RadioButton ansThree = (RadioButton) view.findViewById(R.id.radioButton6);
        ansThree.setText(currQuestion.getAnsThree());

        RadioButton ansFour = (RadioButton) view.findViewById(R.id.radioButton5);
        ansFour.setText(currQuestion.getAnsFour());

        if(selectedAns == 0) {
            ansOne.toggle();
            ansOne.setTextColor(Color.RED);
        } else if (selectedAns == 1) {
            ansTwo.toggle();
            ansTwo.setTextColor(Color.RED);
        } else if (selectedAns == 2) {
            ansThree.toggle();
            ansThree.setTextColor(Color.RED);
        } else {
            ansFour.toggle();
            ansFour.setTextColor(Color.RED);
        }

        int correct = currQuestion.getCorrectAns();
        if(correct == 1) {
            ansOne.setTextColor(Color.GREEN);
        } else if (correct == 2) {
            ansTwo.setTextColor(Color.GREEN);
        } else if (correct == 3) {
            ansThree.setTextColor(Color.GREEN);
        }  else {
            ansFour.setTextColor(Color.GREEN);
        }

        if((selectedAns + 1) == correct) {
            activity.addCorrect();
        }
        activity.addAnswered();

        TextView answerText = (TextView) view.findViewById(R.id.textView6);
        answerText.setText("You got " + activity.getCorrect() + " out of " + activity.getPosition() + " correct");

        submit = (Button) view.findViewById(R.id.button4);
        if (activity.getPosition() >=  (questions.size())) {
            submit.setText("Finish");
        } else {
            submit.setText("Next");
        }
        submit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            selectedAns = args.getInt("selected");
        }
    }

    @Override
    public void onClick(View v) {
        if (activity.getPosition() >=  (questions.size())) {
            Intent intent = new Intent(getActivity(), ListActivity.class);
            startActivity(intent);
        } else {
            Fragment questionFrag = new QuestionFrag();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_placeholder, questionFrag);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

}
