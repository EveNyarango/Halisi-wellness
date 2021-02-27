package com.example.halisiwellness.network;

import com.example.halisiwellness.models.UserData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("auth/api/register/")
    Call<UserResponse> saveUser(@Body UserData userRequest);
}
