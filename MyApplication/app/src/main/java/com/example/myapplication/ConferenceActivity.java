package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ConferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference);

        Button buttonConferenceCancelObject = findViewById(R.id.buttonConferenceCancel);

        buttonConferenceCancelObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ConferenceActivity.this, IndexActivity.class);
                ConferenceActivity.this.startActivity(myIntent);
            }
        });
        Button buttonConferenceSaveObject = findViewById(R.id.buttonConferenceSave);
        buttonConferenceSaveObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ConferenceActivity.this, SaveActivity.class);
                ConferenceActivity.this.startActivity(myIntent);
            }
        });
    }





}
