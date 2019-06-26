package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class SaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        /*Button buttonCancelObject = findViewById(R.id.buttonCancel);

        buttonCancelObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent myIntent = new Intent(SaveActivity.this, ConferenceActivity.class);
                //SaveActivity.this.startActivity(myIntent);
                finish();

            }
        });*/
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        ImageButton BackButtonObject = findViewById(R.id.BackButton);

        BackButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }


}

//TODO: The Details should get saved with the file.