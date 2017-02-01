package edu.washington.mtn217.quizdroid;


import android.content.Intent;
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
public class MarvelQ2Ans extends Fragment implements  View.OnClickListener {
    RadioGroup marvelTwo;
    Button submit;
    View view;
    TextView result;
    int correctAns;
    RadioButton ans;
    RadioButton correct;

    public MarvelQ2Ans() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_marvel_q2_ans, container, false);
        marvelTwo = (RadioGroup) view.findViewById(R.id.marvelTwo);
        submit = (Button) view.findViewById(R.id.button8);
        result = (TextView) view.findViewById(R.id.textView11);
        correct = (RadioButton) view.findViewById(R.id.radioButton20);
        submit.setOnClickListener(this);
        marvelTwo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ans = (RadioButton) radioGroup.findViewById(i);
                submit.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            correctAns = args.getInt("correctAns");
        }
    }

    @Override
    public void onClick(View v) {
        if(submit.getText().toString().equals(getString(R.string.submit))) {
            submit.setText(getString(R.string.finish));
            correct.setTextColor(Color.GREEN);

            if(ans.getId() != correct.getId()) {
                ans.setTextColor(Color.RED);
                if(correctAns == 1) {
                    result.setText(getString(R.string.oneOftwo));
                } else {
                    result.setText(getString(R.string.two));
                }
            } else {
                correctAns++;
                if(correctAns == 2) {
                    result.setText(getString(R.string.allTwo));
                } else if (correctAns == 1){
                    result.setText(getString(R.string.oneOftwo));
                }
            }

            result.setVisibility(View.VISIBLE);

        } else {
            Intent intent = new Intent(getActivity(), ListActivity.class);
            startActivity(intent);
        }
    }

}
