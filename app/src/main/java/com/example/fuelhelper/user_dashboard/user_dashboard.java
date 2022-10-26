package com.example.fuelhelper.user_dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fuelhelper.R;
import com.example.fuelhelper.register_vehicle;
import com.example.fuelhelper.user_check_fuel_station;


public class user_dashboard extends AppCompatActivity {
    Button registerVehicleBtn, checkFuelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        registerVehicleBtn = findViewById(R.id.registerVehiclebutton);
        checkFuelBtn = findViewById(R.id.checkFuelStationBtn);

        registerVehicleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(user_dashboard.this, register_vehicle.class);
                startActivity(i);
            }
        });

        checkFuelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_dashboard.this, user_check_fuel_station.class);
                startActivity(intent);
            }
        });
    }
}