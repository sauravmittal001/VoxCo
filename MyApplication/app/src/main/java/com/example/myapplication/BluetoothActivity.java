package com.example.myapplication;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class BluetoothActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        Button buttonON = findViewById(R.id.buttonON);
        Button buttonOFF = findViewById(R.id.buttonOFF);
        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        buttonON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bluetoothAdapter == null) {
                    Toast toast = Toast.makeText(getApplicationContext(), "VoxCo Not Supported", Toast.LENGTH_SHORT);
                    toast.show();

                } else {
                    if (!bluetoothAdapter.isEnabled()) {
                        startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), 1);
                        Toast.makeText(getApplicationContext(), "VoxCo Connection Turned ON", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        buttonOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothAdapter.disable();
                Toast.makeText(getApplicationContext(), "VoxCo Connection Turned OFF", Toast.LENGTH_SHORT).show();
            }
        });
    }

}