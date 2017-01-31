package edu.washington.mtn217.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MarvelOverview extends AppCompatActivity {

    Button startMarvel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marvel_overview);

        startMarvel = (Button) findViewById(R.id.button10);
        startMarvel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarvelOverview.this, MarvelOne.class);
                startActivity(intent);
            }
        });
    }
}
