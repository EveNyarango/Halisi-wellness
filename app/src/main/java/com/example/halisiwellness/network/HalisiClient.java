package com.example.halisiwellness.network;



import android.util.Log;

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

    private static Retrofit retrofit;
    private static final String HALISI_BASE_URL = "https://young-tundra-50012.herokuapp.com/";
    private static Object LastAppointmentObject;
    private static dataObjectClass dataObjectClass;

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(HALISI_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            LastAppointmentObject = new LastAppointmentObject("MM/YY/DD");

            dataObjectClass = new dataObjectClass("name", "phone", (com.example.halisiwellness.models.LastAppointmentObject) LastAppointmentObject);

            MainObjectClass mainObjectClass = new MainObjectClass(dataObjectClass);

            AppointmentRetrofitClient appointmentRetrofitClient = retrofit.create(AppointmentRetrofitClient.class);
            Call<MainResponseObjectClass>  res =  AppointmentRetrofitClient.GetPostValue();

            res.enqueue(new Callback<MainResponseObjectClass>() {
                @Override
                public void onResponse(Call<MainResponseObjectClass> call, Response<MainResponseObjectClass> response) {

                String phone =  response.body().getPhone();
                 String name =  response.body().getName();
                 LastAppointmentObject object  = response.body().getLastAppointmentObject();

                         String date = object.getDate();

                         Log.d("name", name);
                         Log.d("phone", phone);
                         Log.d("date", date);

                }

                @Override
                public void onFailure(Call<MainResponseObjectClass> call, Throwable t) {

                    Log.d("response", "fail");

                }
            });

        }
        return retrofit;
    }
}
