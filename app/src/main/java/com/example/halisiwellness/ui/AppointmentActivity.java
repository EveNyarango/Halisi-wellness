package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.halisiwellness.R;

import java.util.Calendar;


public class AppointmentActivity extends AppCompatActivity {

    private static final String TAG = "AppointmentActivity";

    EditText etDate, etPhone,  etName1, etName;
    Button btnSubmit;
    private EditText mDisplayDate;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_APPOINTMENT = "myapp";
    private static final String KEY_PATIENTNAME = "patientname";
    private  static final String KEY_CITY = "city";
    private static final String KEY_PHONE = "phone number";
    private static final String KEY_DATE = "date";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        mDisplayDate = (EditText) findViewById(R.id.etDate);

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

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal .get(Calendar.YEAR);
                int month = cal .get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AppointmentActivity.this,
                        android.R.style.Theme_Holo_Dialog_NoActionBar_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);

            }
        };


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(KEY_CITY, etName1.getText().toString());
                editor.putString(KEY_PATIENTNAME, etName.getText().toString());
                editor.putString(KEY_PHONE, etPhone.getText().toString());
                editor.putString(KEY_DATE, etDate.getText().toString());



                editor.apply();

                Toast.makeText(AppointmentActivity.this, "Appointment submitted  successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AppointmentActivity.this, DocActivity.class);
                startActivity(intent);
            }
        });

    }
}