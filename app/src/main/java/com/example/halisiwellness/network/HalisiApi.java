package com.example.halisiwellness.network;

import com.example.halisiwellness.models.UserData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HalisiApi {

    @POST("auth/api/register/")
    Call<UserData> register(@Body UserData userData);

    String BASE_URL = "https://young-tundra-50012.herokuapp.com/";

}
