package com.example.myapplication;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;


public class BluetoothActivity extends AppCompatActivity {
    ArrayAdapter aAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
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
                        Toast.makeText(getApplicationContext(), "Turning ON VoxCo Connection", Toast.LENGTH_SHORT).show();
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


        Button buttonPairedObject = findViewById(R.id.buttonPaired);
        buttonPairedObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bluetoothAdapter == null) {
                    Toast.makeText(getApplicationContext(), "Bluetooth Not Supported", Toast.LENGTH_SHORT).show();
                } else {
                    Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
                    ArrayList<String> list = new ArrayList<>();
                    if (pairedDevices.size() > 0) {
                        for (BluetoothDevice device : pairedDevices) {
                            String deviceName = device.getName();
                            String macAddress = device.getAddress();
                            int somethings = device.getBondState();
                            list.add("Name: " + deviceName + "\n\nMAC Address: " + macAddress + "\nBond State: " + somethings + "\n");
                        }
                        ListView listView = findViewById(R.id.listviewPairedDevices);
                        aAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                        listView.setAdapter(aAdapter);
                    }
                }
            }
        });

        Button buttonDiscoverObject = findViewById(R.id.buttonDiscover);

        buttonDiscoverObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(BluetoothActivity.this, DiscoverActivity.class);
                BluetoothActivity.this.startActivity(myIntent);
            }
        });

    }


}


//TODO: Bluetooth Connect feature
//TODO: Improve the UI