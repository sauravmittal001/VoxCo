package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        Button buttonCancelObject = findViewById(R.id.buttonCancel);

        buttonCancelObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent myIntent = new Intent(SaveActivity.this, ConferenceActivity.class);
                SaveActivity.this.startActivity(myIntent);*/
                finish();

            }
        });


    }
}

//TODO: The Details should get saved with the file.