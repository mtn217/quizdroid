package edu.washington.mtn217.quizdroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
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
public class PhysQ1Ans extends Fragment implements View.OnClickListener {
    RadioGroup physicsOne;
    Button submit;
    View view;
    Fragment physicsTwo;
    Fragment physicsTwoAns;
    TextView result;
    int correctAns;
    RadioButton ans;


    public PhysQ1Ans() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_phys_q1_ans, container, false);

        physicsOne = (RadioGroup) view.findViewById(R.id.physicsOne);
        submit = (Button) view.findViewById(R.id.button5);
        result = (TextView) view.findViewById(R.id.ansText);
        submit.setOnClickListener(this);
        physicsOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
            if (ans.getId() == 2131427440) { //change number
                ans.setTextColor(Color.GREEN);
                result.setText(getString(R.string.oneCorrect));
                correctAns++;
            } else {
                ans.setTextColor(Color.RED);
                RadioButton correct = (RadioButton) physicsOne.findViewById(R.id.radioButton8);
                correct.setTextColor(Color.GREEN);
                result.setText(getString(R.string.one));
            }
            result.setVisibility(View.VISIBLE);
        } else {
            physicsTwo = new PhysQ2();
            physicsTwoAns = new PhysQ2Ans();

            Bundle args = new Bundle();
            args.putInt("correctAns", correctAns);
            physicsTwoAns.setArguments(args);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_placeholder, physicsTwo);
            fragmentTransaction.replace(R.id.fragment_other, physicsTwoAns);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
