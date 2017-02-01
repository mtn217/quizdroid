package edu.washington.mtn217.quizdroid;

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
public class PhysicsOverview extends Fragment implements View.OnClickListener {
    View view;
    Fragment physicsOne;
    Fragment physicsOneAns;

    public PhysicsOverview() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_physics_overview, container, false);
        Button start = (Button) view.findViewById(R.id.button3);
        start.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        physicsOne = new PhysQ1();
        physicsOneAns = new PhysQ1Ans();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_placeholder, physicsOne);
        fragmentTransaction.replace(R.id.fragment_other, physicsOneAns);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
