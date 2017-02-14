package edu.washington.mtn217.quizdroid;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFrag extends Fragment implements View.OnClickListener {
    private View view;
    private Topic currTopic;
    private List<Question> questions;
    private int index;
    private MainActivity activity;
    private Question currQuestion;

    public QuestionFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_question, container, false);
        Intent intent = getActivity().getIntent();
        String json = (String)intent.getSerializableExtra(ListActivity.MESSAGE);

        Gson gson = new Gson();
        currTopic = gson.fromJson(json, Topic.class);
        questions = currTopic.getAllQuestions();

        activity = (MainActivity) getActivity();
        currQuestion = questions.get(activity.getPosition());
        TextView question = (TextView) view.findViewById(R.id.textView);
        question.setText(currQuestion.getQuestion());

        RadioButton ansOne = (RadioButton) view.findViewById(R.id.radioButton4);
        ansOne.setText(currQuestion.getAnsOne());

        RadioButton ansTwo = (RadioButton) view.findViewById(R.id.radioButton3);
        ansTwo.setText(currQuestion.getAnsTwo());

        RadioButton ansThree = (RadioButton) view.findViewById(R.id.radioButton2);
        ansThree.setText(currQuestion.getAnsThree());

        RadioButton ansFour = (RadioButton) view.findViewById(R.id.radioButton);
        ansFour.setText(currQuestion.getAnsFour());

        final Button submit = (Button) view.findViewById(R.id.button2);

        RadioGroup answers = (RadioGroup) view.findViewById(R.id.answers);
        answers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton ans = (RadioButton) radioGroup.findViewById(i);
                index = radioGroup.indexOfChild(ans);
                submit.setVisibility(View.VISIBLE);
            }
        });

        submit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment answer = new Answer();

        Bundle args = new Bundle();
        args.putInt("selected", index);
        answer.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_placeholder, answer);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
