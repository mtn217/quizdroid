package edu.washington.mtn217.quizdroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MarvelQ1Ans extends Fragment implements View.OnClickListener {
    RadioGroup marvelOne;
    Button submit;
    View view;
    Fragment marvelTwo;
    Fragment marvelTwoAns;
    TextView result;
    int correctAns;
    RadioButton correct;
    RadioButton ans;

    public MarvelQ1Ans() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_marvel_q1_ans, container, false);
        marvelOne = (RadioGroup) view.findViewById(R.id.marvelOne);
        submit = (Button) view.findViewById(R.id.button9);
        result = (TextView) view.findViewById(R.id.textView13);
        correct = (RadioButton) view.findViewById(R.id.radioButton23);
        submit.setOnClickListener(this);
        marvelOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ans = (RadioButton) radioGroup.findViewById(i);
                submit.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        if(submit.getText().toString().equals(getString(R.string.submit))) {
            submit.setText(getString(R.string.next));
            correct.setTextColor(Color.GREEN);

            if (ans.getId() == correct.getId()) {
                result.setText(getString(R.string.oneCorrect));
                correctAns++;
            } else {
                ans.setTextColor(Color.RED);
                result.setText(getString(R.string.one));
            }
            result.setVisibility(View.VISIBLE);

        } else {
            marvelTwo = new MarvelQ2();
            marvelTwoAns = new MarvelQ2Ans();

            Bundle args = new Bundle();
            args.putInt("correctAns", correctAns);
            marvelTwoAns.setArguments(args);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_placeholder, marvelTwo);
            fragmentTransaction.replace(R.id.fragment_other, marvelTwoAns);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
