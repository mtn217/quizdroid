package edu.washington.mtn217.quizdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PhysicsOverview extends AppCompatActivity {

    Button startPhysics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics_overview);

        startPhysics = (Button) findViewById(R.id.startPhysics);
        startPhysics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhysicsOverview.this, PhysicsOne.class);
                startActivity(intent);
            }
        });
    }
}
