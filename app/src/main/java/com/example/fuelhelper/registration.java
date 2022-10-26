package com.example.fuelhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fuelhelper.user_dashboard.user_dashboard;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class registration extends AppCompatActivity {
    Button registerBtn;
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://192.168.8.100:5000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registerBtn = findViewById(R.id.registerButton);

        EditText nameEdit = findViewById(R.id.editTextNameReg);
        EditText emailEdit = findViewById(R.id.editTextEmailReg);
        EditText passwordEdit = findViewById(R.id.ediTextPasswordReg);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(registration.this, user_dashboard.class);
                startActivity(i);
            }
        });

        //register user method
        /*
        * there are 2 users
        * 1 normal user | role = 0
        * 2 fuel station owner | role 1
        * */
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String, String> map = new HashMap<>();

                map.put("name", nameEdit.getText().toString());
                map.put("email", emailEdit.getText().toString());
                map.put("password", passwordEdit.getText().toString());

                Call<Void> call = retrofitInterface.executeSignup(map);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.code() == 200){
                            Toast.makeText(registration.this, "Signed up successfully", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(registration.this, user_dashboard.class);
                            startActivity(i);
                        }else if (response.code() == 400){
                            Toast.makeText(registration.this, "Already Registered", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(registration.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}