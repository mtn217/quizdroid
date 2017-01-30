package edu.washington.mtn217.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MathOne extends AppCompatActivity {

    Button button5;
    RadioGroup mathOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_one);

        mathOne = (RadioGroup) findViewById(R.id.mathOne);
        button5 = (Button) findViewById(R.id.button5);

        mathOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                button5.setVisibility(View.VISIBLE);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathOne.this, MathOneAns.class);
                startActivity(intent);
            }
        });
    }
}
