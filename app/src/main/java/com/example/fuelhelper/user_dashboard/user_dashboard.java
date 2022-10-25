package com.example.fuelhelper.user_dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fuelhelper.R;
import com.example.fuelhelper.register_vehicle;


public class user_dashboard extends AppCompatActivity {
    Button registerVehicleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        registerVehicleBtn = findViewById(R.id.registerVehiclebutton);

        registerVehicleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(user_dashboard.this, register_vehicle.class);
                startActivity(i);
            }
        });
    }
}