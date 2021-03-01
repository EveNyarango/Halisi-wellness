package com.example.halisiwellness.network;

import com.example.halisiwellness.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiaryClient {

    public static Retrofit retrofit = null;

    public static HalisiApi diaryRequest() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Constants.HALISI_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(HalisiApi.class);
    }
}
