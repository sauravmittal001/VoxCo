package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Locale;


public class ConferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        FloatingActionButton buttonConferenceCancelObject = findViewById(R.id.buttonConferenceCancel);

        buttonConferenceCancelObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent myIntent = new Intent(ConferenceActivity.this, IndexActivity.class);
                ConferenceActivity.this.startActivity(myIntent);*/
                finish();
            }
        });
        FloatingActionButton buttonConferenceSaveObject = findViewById(R.id.buttonConferenceSave);
        buttonConferenceSaveObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ConferenceActivity.this, SaveActivity.class);
                ConferenceActivity.this.startActivity(myIntent);
            }
        });


        checkPermission();


        //doosra
        final EditText editTextdoosra = findViewById(R.id.editTextdoosra);

        final SpeechRecognizer mSpeechRecognizerdoosra = SpeechRecognizer.createSpeechRecognizer(this);
        final Intent mSpeechRecognizerIntentdoosra = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mSpeechRecognizerIntentdoosra.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        mSpeechRecognizerIntentdoosra.putExtra(RecognizerIntent.EXTRA_LANGUAGE,
                Locale.getDefault());

        mSpeechRecognizerdoosra.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundledoosra) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundledoosra) {
                //getting all the matches
                ArrayList<String> matches = bundledoosra
                        .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                //displaying the first match
                if (matches != null)
                    editTextdoosra.setText(matches.get(0));
            }


            @Override
            public void onPartialResults(Bundle bundledoosra) {

            }

            @Override
            public void onEvent(int i, Bundle bundledoosra) {

            }
        });

        findViewById(R.id.buttondoosra).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_UP:
                        mSpeechRecognizerdoosra.stopListening();
                        editTextdoosra.setHint("   Person 2 input");
                        break;

                    case MotionEvent.ACTION_DOWN:
                        mSpeechRecognizerdoosra.startListening(mSpeechRecognizerIntentdoosra);
                        editTextdoosra.setText("");
                        editTextdoosra.setHint("   Listening...");
                }
                return false;
            }
        });

        //doosra khatam
        final EditText editText = findViewById(R.id.editText);


        final SpeechRecognizer mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);


        final Intent mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,
                Locale.getDefault());


        mSpeechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {
                //getting all the matches
                ArrayList<String> matches = bundle
                        .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                //displaying the first match
                if (matches != null)
                    editText.setText(matches.get(0));
            }


            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });


        findViewById(R.id.button).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_UP:
                        mSpeechRecognizer.stopListening();
                        editText.setHint("   Person 1 input");
                        break;

                    case MotionEvent.ACTION_DOWN:
                        mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
                        editText.setText("");
                        editText.setHint("   Listening...");
                }
                return false;
            }
        });


    }


    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + getPackageName()));
                startActivity(intent);
                finish();
            }
        }
    }


}

//TODO: Connect to Raspberry Pi and stream in audio array
//TODO: Record the text-audio in a file and save it in system hardware
//TODO: Improve the UI
