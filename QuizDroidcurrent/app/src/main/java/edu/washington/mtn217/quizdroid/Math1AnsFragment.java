package edu.washington.mtn217.quizdroid;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Math1AnsFragment extends Fragment implements View.OnClickListener{
    RadioGroup mathOne;
    Button submit;
    View view;
    Fragment mathTwo;
    TextView result;
    int choice;

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
        submit.setOnClickListener(this);
        mathOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                choice = i;
                String x = "" + choice;
                Log.i("MainActivity", x);
                submit.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        if(submit.getText().toString().equals("Submit")) {
            submit.setText("next");
            if (choice == 2131427423) {
                result.setText("You got 1 out of 1 correct");
            } else {
                result.setText("You got 0 out of 1 correct");
            }
            result.setVisibility(View.VISIBLE);
        } else {
            mathTwo = new MathTwoFragment();
            //mathTwoAns = new MathTwoAnsFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_placeholder, mathTwo);
            //fragmentTransaction.replace(R.id.fragment_other, mathAnsTwo);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
