package com.example.halisiwellness.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
//method1
//    private static final String HALISI_BASE_URL = "https://young-tundra-50012.herokuapp.com/";
//    private static Retrofit retrofit;
//    private static RetrofitClient mInstance;
//
//    private RetrofitClient() {
//        retrofit = new Retrofit.Builder()
//                .baseUrl(HALISI_BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }
//    public static synchronized RetrofitClient getInstance(){
//        if(mInstance == null) {
//            mInstance = new RetrofitClient();
//        }
//        return mInstance;
//    }
//    public HalisiApi getApi() {
//        return retrofit.create(HalisiApi.class);
//    }

//    method2
    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://young-tundra-50012.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }
    public static UserService getUserService(){
        UserService userService = getRetrofit().create(UserService.class);

        return userService;
    }
}
