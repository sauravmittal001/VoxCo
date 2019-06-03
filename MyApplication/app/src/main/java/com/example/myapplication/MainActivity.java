package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;
=======
import android.os.Handler;
>>>>>>> e9a9ae9dcb66fba49c8d567c4f088fd3075f733a

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    //public static final android.util.Log Log = ; // add
    Timer timer;

=======
>>>>>>> e9a9ae9dcb66fba49c8d567c4f088fd3075f733a
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        //Log.d("myTag", "This is my message"); // add

        timer = new Timer();

        timer.schedule(new TimerTask() {
=======
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

>>>>>>> e9a9ae9dcb66fba49c8d567c4f088fd3075f733a
            @Override
            public void run() {
                Intent indent = new Intent(MainActivity.this, IndexActivity.class);
                startActivity(indent);
            }
<<<<<<< HEAD
        }, 500);
=======
        }, 1000L);
>>>>>>> e9a9ae9dcb66fba49c8d567c4f088fd3075f733a

    }
}