package edu.washington.mtn217.quizdroid;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class PhysicsOne extends AppCompatActivity {

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics_one);

        submit = (Button) findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhysicsOne.this, PhysicsTwoAns.class);
                startActivity(intent);
            }
        });
    }

    public void getSubmit(View v) {
        switch(v.getId())
        {
            case R.id.radioButton:
                submit.setVisibility(View.VISIBLE);
                break;
            case R.id.radioButton2:
                submit.setVisibility(View.VISIBLE);
                break;
            case R.id.radioButton3:
                submit.setVisibility(View.VISIBLE);
                break;
            case R.id.radioButton4:
                submit.setVisibility(View.VISIBLE);
                break;
        }
    }
}
