package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IndoorActivity extends Activity {

    static final private double EMA_FILTER = 0.6;
    private static double mEMA = 0.0;
    final Handler mHandler = new Handler();
    TextView mStatusView;
    MediaRecorder mRecorder;
    final Runnable updater = new Runnable() {

        public void run() {
            updateTv();
        }

        ;
    };
    Thread runner;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_indoor);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        mStatusView = (TextView) findViewById(R.id.status);
        Button colorButton = findViewById(R.id.IndoorColorButton);
        ImageButton buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (runner == null) {
            runner = new Thread() {
                public void run() {
                    while (runner != null) {
                        try {
                            Thread.sleep(25);
                            Log.i("Noise", "Tock");
                        } catch (InterruptedException e) {
                        }
                        ;
                        mHandler.post(updater);
                    }
                }
            };
            runner.start();
            Log.d("Noise", "play runner()");
        }
    }

    public void onResume() {
        super.onResume();
        startRecorder();
    }

    public void onPause() {
        super.onPause();
        stopRecorder();
    }

    public void startRecorder() {
        if (mRecorder == null) {
            mRecorder = new MediaRecorder();
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mRecorder.setOutputFile("/dev/null");
            try {
                mRecorder.prepare();
            } catch (java.io.IOException ioe) {
                android.util.Log.e("[Monkey]", "IOException: " +
                        android.util.Log.getStackTraceString(ioe));

            } catch (java.lang.SecurityException e) {
                android.util.Log.e("[Monkey]", "SecurityException: " +
                        android.util.Log.getStackTraceString(e));
            }
            try {
                mRecorder.start();
            } catch (java.lang.SecurityException e) {
                android.util.Log.e("[Monkey]", "SecurityException: " +
                        android.util.Log.getStackTraceString(e));
            }

            //mEMA = 0.0;


        }

    }

    public void stopRecorder() {
        if (mRecorder != null) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
        }
    }

//    public void updateTv() {
//        mStatusView.setText(Double.toString((getAmplitudeEMA())) + " dB");
//    }

//    public void updateTv() {
//        mStatusView.setText(Double.toString(soundDb(getAmplitude())) + " dB");
//    }
    View view;

    public void updateTv() {
        mStatusView.setText(Double.toString(round(convertdDb(getAmplitude()))) + " dB");
        View colorButton = findViewById(R.id.IndoorColorButton);
        if (convertdDb(getAmplitude()) >= (double)60) {
            Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
//            v.vibrate(VibrationEffect.DEFAULT_AMPLITUDE);
            v.vibrate(400);
//            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            colorButton.setBackgroundColor(Color.rgb(255,99,33));
        }
        else {
            colorButton.setBackgroundColor(Color.rgb(255,255,255));
        }
    }


    public double round(double value) {
        value  *= 1;
        Integer i = (int)value;
        double j = (double)i;
        j /= 1;
        return j;
    }


    public double convertdDb(double amplitude) {
        // Cellphones can catch up to 90 db + -
        // getMaxAmplitude returns a value between 0-32767 (in most phones). that means that if the maximum db is 90, the pressure
        // at the microphone is 0.6325 Pascal.
        // it does a comparison with the previous value of getMaxAmplitude.
        // we need to divide maxAmplitude with (32767/0.6325)
        //51805.5336 or if 100db so 46676.6381
        double EMA_FILTER = 0.6;
        SharedPreferences sp = this.getSharedPreferences("device-base", MODE_PRIVATE);
        double amp = (double) sp.getFloat("amplitude", 0);
        double mEMAValue = EMA_FILTER * amplitude + (1.0 - EMA_FILTER) * mEMA;
        Log.d("db", Double.toString(amp));
        //Assuming that the minimum reference pressure is 0.000085 Pascal (on most phones) is equal to 0 db
        // samsung S9 0.000028251
        return 20 * (float) Math.log10((mEMAValue / 51805.5336) / 0.000028251);
    }

    public double soundDb(double ampl) {
        return 20 * Math.log10(getAmplitudeEMA() / ampl);
    }

    public double getAmplitude() {
        if (mRecorder != null)
            return (mRecorder.getMaxAmplitude());
        else
            return 0;

    }

    public double getAmplitudeEMA() {
        double amp = getAmplitude();
        mEMA = EMA_FILTER * amp + (1.0 - EMA_FILTER) * mEMA;
        return mEMA;
    }

}
