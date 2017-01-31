package com.example.iguest.intactfrag;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    public static final String MESSAGE = "com.example.iguest.message";

    private boolean isFirstFragmentOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnActivity = (Button)findViewById(R.id.btnActivity);
        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch next activity
                Intent i = new Intent(MainActivity.this, NextActivity.class);

                i.putExtra(MESSAGE, "This is from Main");

                startActivity(i);
            }
        });

        Button btnFragment = (Button)findViewById(R.id.btnFragment);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Rotate from fragment whichever to the otherwhichever
                Fragment fragToDisplay = null;

                if (isFirstFragmentOn) {
                    // Display second
                    isFirstFragmentOn = false;
                    fragToDisplay = new FirstFragment();
                }
                else {
                    // Display first
                    isFirstFragmentOn = true;
                    fragToDisplay = SecondFragment.newInstance("foo", "bar");
                }

                FragmentTransaction tx = getFragmentManager().beginTransaction();
                tx.replace(R.id.fragment_placeholder, fragToDisplay);
                tx.commit();
            }
        });

        isFirstFragmentOn = true;
        FirstFragment ff = new FirstFragment();
        FragmentTransaction tx = getFragmentManager().beginTransaction();
        tx.replace(R.id.fragment_placeholder, ff);
        tx.commit();
    }
}
