package edu.washington.mtn217.quizdroid;

import android.app.FragmentTransaction;
import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String choice = intent.getStringExtra(ListActivity.MESSAGE);

        Fragment fragToDisplay = null;
        Log.i("MainActivity", choice);

        if(choice.equals("0")) {
            fragToDisplay = new MathOverview();
        } else if (choice.equals("1")){
            fragToDisplay = new PhysicsOverview();
        } else {
            fragToDisplay = new MarvelOverview();
        }

        FragmentTransaction tx = getFragmentManager().beginTransaction();
        tx.replace(R.id.fragment_placeholder, fragToDisplay);
        tx.commit();
    }
}
