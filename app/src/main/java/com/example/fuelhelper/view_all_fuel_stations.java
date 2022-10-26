package com.example.fuelhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class view_all_fuel_stations extends AppCompatActivity {
    CardView cardView01 , cardView02, cardView03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_fuel_stations);

        cardView01 = findViewById(R.id.listCardView01);
        cardView02 = findViewById(R.id.listCardView02);

        //cardView01.setBackgroundResource(R.drawable.box01);
        cardView01.setBackgroundResource(R.drawable.box01);
        cardView02.setBackgroundResource(R.drawable.box01);
    }
}