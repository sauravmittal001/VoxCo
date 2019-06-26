package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        Button StartConferenceButtonObject = findViewById(R.id.StartConferenceButton);

        StartConferenceButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(IndexActivity.this, ConferenceActivity.class);
                IndexActivity.this.startActivity(myIntent);
            }
        });


        final Button OutdoorButtonObject = findViewById(R.id.OutdoorButton);

        OutdoorButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(IndexActivity.this, OutdoorActivity.class);
                IndexActivity.this.startActivity(myIntent);
            }
        });

        final Button IndoorButtonObject = findViewById(R.id.IndoorButton);

        IndoorButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(IndexActivity.this, IndoorActivity.class);
                IndexActivity.this.startActivity(myIntent);
            }
        });
        FloatingActionButton RecordButtonObject = findViewById(R.id.recordButton);

        RecordButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(IndexActivity.this, RecordActivity.class);
                IndexActivity.this.startActivity(myIntent);
            }
        });

        FloatingActionButton FilesButtonObject = findViewById(R.id.FilesButton);

        FilesButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(IndexActivity.this, FilesActivity.class);
                IndexActivity.this.startActivity(myIntent);
            }
        });
/*
        final Button ConnectButtonObject = findViewById(R.id.ConnectButton);

        ConnectButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(IndexActivity.this, BluetoothActivity.class);
                IndexActivity.this.startActivity(myIntent);
            }
        });
*/
        ImageButton BackButtonObject = findViewById(R.id.BackButton);

        BackButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        //added pair activity

        FloatingActionButton PairButtonObject = findViewById(R.id.PairButton);

        PairButtonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(IndexActivity.this, PairActivity.class);
                IndexActivity.this.startActivity(myIntent);
            }
        });

        /*
        // toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }*/

    }

}


//TODO: Improve UI