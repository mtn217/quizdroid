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
public class Math1AnsFragment extends Fragment implements View.OnClickListener {
    RadioGroup mathOne;
    Button submit;
    View view;
    Fragment mathTwo;
    Fragment mathTwoAns;
    TextView result;
    int correctAns;
    RadioButton ans;
    RadioButton correct;

    public Math1AnsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_math1_ans, container, false);

        mathOne = (RadioGroup) view.findViewById(R.id.mathOne);
        submit = (Button) view.findViewById(R.id.button4);
        result = (TextView) view.findViewById(R.id.textView5);
        correct = (RadioButton) mathOne.findViewById(R.id.radioButton2);
        submit.setOnClickListener(this);
        mathOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
            mathTwo = new MathTwoFragment();
            mathTwoAns = new Math2Ans();

            Bundle args = new Bundle();
            args.putInt("correctAns", correctAns);
            mathTwoAns.setArguments(args);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_placeholder, mathTwo);
            fragmentTransaction.replace(R.id.fragment_other, mathTwoAns);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
