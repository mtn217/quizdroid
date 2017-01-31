package edu.washington.mtn217.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MathTwo extends AppCompatActivity {

    Button finish;
    RadioGroup mathTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_two);

        mathTwo = (RadioGroup) findViewById(R.id.mathOne);
        finish = (Button) findViewById(R.id.button5);

        mathTwo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                finish.setVisibility(View.VISIBLE);
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathTwo.this, MathTwoAns.class);
                startActivity(intent);
            }
        });
    }
}
