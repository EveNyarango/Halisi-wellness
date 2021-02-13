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

    EditText etDate, etVenue, etPhone;
    Button btnSubmit;
    SharedPreferences sp7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        etDate = findViewById(R.id.etDate);
//        etTime = findViewById(R.id.etTime);
        etVenue = findViewById(R.id.etVenue);
        etPhone = findViewById(R.id.etPhone);
        btnSubmit = findViewById(R.id.btnSubmit);
        sp7 = getSharedPreferences("f4", MODE_PRIVATE);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable s1 = etDate.getText();
                Editable s2 = etPhone.getText();
                Editable s3 = etVenue.getText();
                String s = "You have an appointment on " + s1 + ", " + s2 + " " + s3;
                SharedPreferences.Editor editor = sp7.edit();
                editor.putString("n1", s);
                editor.apply();
                Toast.makeText(AppointmentActivity.this, "Submition successfully", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(AppointmentActivity.this, MainActivity.class);
//                startActivity(intent);
            }
        });

//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(AppointmentActivity.this, MainActivity.class);
//                startActivity(i);
//                finish();
//
//            }
//        });
    }
}