package edu.washington.mtn217.quizdroid;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MathOverview extends Fragment implements View.OnClickListener {
    View view;
    Fragment mathOne;
    Fragment mathOneAns;

    public MathOverview() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_math_overview, container, false);
        Button start = (Button) view.findViewById(R.id.button2);
        start.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        mathOne = new MathOneFragment();
        mathOneAns = new Math1AnsFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_placeholder, mathOne);
        fragmentTransaction.replace(R.id.fragment_other, mathOneAns);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}