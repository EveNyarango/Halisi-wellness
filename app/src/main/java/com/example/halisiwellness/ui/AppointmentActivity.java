package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.halisiwellness.R;


public class AppointmentActivity extends AppCompatActivity {

    private static final String TAG = "AppointmentActivity";

    EditText etDate, etPhone,  etName1, etName;
    Button btnSubmit;


    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_APPOINTMENT = "myapp";
    private static final String KEY_PATIENTNAME = "patientname";
    private  static final String KEY_CITY = "city";
    private static final String KEY_PHONE = "phone number";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        etDate = findViewById(R.id.etDate);
       etName1 = findViewById(R.id.etName1);
        etPhone = findViewById(R.id.etPhone);
        etName = findViewById(R.id.etName);
        btnSubmit = findViewById(R.id.btnSubmit);
        sharedPreferences = getSharedPreferences(SHARED_PREF_APPOINTMENT, MODE_PRIVATE);

        String patientname = sharedPreferences.getString(KEY_PATIENTNAME, null);

        if(patientname != null){
            Intent intent = new Intent(AppointmentActivity.this, DocActivity.class);
            startActivity(intent);
        }


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(KEY_CITY, etName1.getText().toString());
                editor.putString(KEY_PATIENTNAME, etName.getText().toString());
                editor.putString(KEY_PHONE, etPhone.getText().toString());



                editor.apply();

                Toast.makeText(AppointmentActivity.this, "Appointment submitted  successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AppointmentActivity.this, DocActivity.class);
                startActivity(intent);
            }
        });

    }
}