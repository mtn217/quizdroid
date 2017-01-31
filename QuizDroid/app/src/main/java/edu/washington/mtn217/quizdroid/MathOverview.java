package edu.washington.mtn217.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MathOverview extends AppCompatActivity {

    Button startMath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_overview);

        startMath = (Button) findViewById(R.id.button4);
        startMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathOverview.this, MathOne.class);
                startActivity(intent);
            }
        });
    }
}
