package com.example.halisiwellness.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HalisiApi {
    @FormUrlEncoded
    @POST("auth/api/register/")
    Call<ResponseBody> register(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
            );

    String BASE_URL = "https://young-tundra-50012.herokuapp.com/";

}
