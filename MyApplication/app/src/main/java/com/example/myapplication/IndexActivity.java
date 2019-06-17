package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Button StartConferenceButtonObject = findViewById(R.id.StartConferenceButton);

        StartConferenceButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(IndexActivity.this, ConferenceActivity.class);
                IndexActivity.this.startActivity(myIntent);
            }
        });

        Button OutdoorButtonObject = findViewById(R.id.OutdoorButton);

        OutdoorButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(IndexActivity.this, OutdoorActivity.class);
                IndexActivity.this.startActivity(myIntent);
            }
        });

        Button IndoorButtonObject = findViewById(R.id.IndoorButton);

        IndoorButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(IndexActivity.this, IndoorActivity.class);
                IndexActivity.this.startActivity(myIntent);
            }
        });

        Button FilesButtonObject = findViewById(R.id.FilesButton);

        FilesButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(IndexActivity.this, FilesActivity.class);
                IndexActivity.this.startActivity(myIntent);
            }
        });

        Button ConnectButtonObject = findViewById(R.id.ConnectButton);

        ConnectButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(IndexActivity.this, BluetoothActivity.class);
                IndexActivity.this.startActivity(myIntent);
            }
        });


    }
}
