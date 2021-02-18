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

    EditText etDate, etPhone, etDocName, etName1, etName;
    Button btnSubmit;
    SharedPreferences sp7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        etDate = findViewById(R.id.etDate);
       etDocName = findViewById(R.id.etDocName);
       etName1 = findViewById(R.id.etName1);
        etPhone = findViewById(R.id.etPhone);
        etName = findViewById(R.id.etName);
        btnSubmit = findViewById(R.id.btnSubmit);
        sp7 = getSharedPreferences("f4", MODE_PRIVATE);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable s1 = etDate.getText();
                Editable s2 = etPhone.getText();
                Editable s3 = etDocName.getText();
                Editable s4 = etName1.getText();
                Editable s5 = etName.getText();
                String s = "You have an appointment on " + s1 + ", " + s2 + " ," + s3 + ", " + s4 + "," + s5 +"";
                SharedPreferences.Editor editor = sp7.edit();
                editor.putString("n1", s);
                editor.apply();
                Toast.makeText(AppointmentActivity.this, "Submission successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AppointmentActivity.this, MainActivity.class);
                startActivity(intent);
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