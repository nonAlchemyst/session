package com.example.savedata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Otpravka {
    @GET("/api/login/")
    Call<LoginResponse> getLogin(@Query("login") String login, @Query("password") String password);
}
