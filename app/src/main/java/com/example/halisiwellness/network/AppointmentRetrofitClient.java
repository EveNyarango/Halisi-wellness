package com.example.halisiwellness.network;

import com.example.halisiwellness.Response.MainResponseObjectClass;
import com.example.halisiwellness.models.MainObjectClass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AppointmentRetrofitClient {

    static Call<MainResponseObjectClass> GetPostValue() {
        return null;
    }

    @POST("appointment/api/book/")
    Call<MainResponseObjectClass> GetPostValue(@Body MainObjectClass mainObjectClass);
}
