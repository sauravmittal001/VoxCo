package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity { //changed "extends AppCompatActivity" to "extends Activity"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button START_CONFERENCE_BUTTON = (Button) findViewById(R.id.START_CONFERENCE_BUTTON);

        START_CONFERENCE_BUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Conference.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
