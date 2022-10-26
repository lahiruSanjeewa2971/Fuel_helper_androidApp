package com.example.fuelhelper;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @POST("/user/login")
    Call<LoginResult> executeLogin(@Body HashMap<String, String> map);

    @POST("/user/register")
    Call<Void> executeSignup(@Body HashMap<String, String> map);

    @GET("/user/logout")
    Call<Void> executeLogout();

    @GET("/user/infor")
    Call<User> executeUserInfo();
}
