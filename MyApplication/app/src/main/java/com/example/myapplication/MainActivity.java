package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //public static final android.util.Log Log = ; // add
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.d("myTag", "This is my message"); // add

        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent indent = new Intent(MainActivity.this, IndexActivity.class);
                startActivity(indent);
                finish();

            }
        }, 500);

    }
}