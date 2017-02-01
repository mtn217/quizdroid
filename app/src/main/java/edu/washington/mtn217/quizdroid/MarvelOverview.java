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
public class MarvelOverview extends Fragment implements View.OnClickListener {
    View view;
    Fragment marvelOne;
    Fragment marvelOneAns;

    public MarvelOverview() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_marvel_overview, container, false);
        Button start = (Button) view.findViewById(R.id.button);
        start.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        marvelOne = new MarvelQ1();
        marvelOneAns = new MarvelQ1Ans();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_placeholder, marvelOne);
        fragmentTransaction.replace(R.id.fragment_other, marvelOneAns);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
