package com.example.halisiwellness.network;



import android.util.Log;

import com.example.halisiwellness.Constants;
import com.example.halisiwellness.Response.MainResponseObjectClass;
import com.example.halisiwellness.models.LastAppointmentObject;
import com.example.halisiwellness.models.MainObjectClass;
import com.example.halisiwellness.models.dataObjectClass;

import org.w3c.dom.CDATASection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HalisiClient {

    public static Retrofit retrofit = null;

    public static HalisiApi urlRequest() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Constants.HALISI_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(HalisiApi.class);
    }
}
