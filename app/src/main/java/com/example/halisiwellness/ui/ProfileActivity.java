package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.halisiwellness.R;

import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity {
    private static final  String TAG = "ProfileActivity";
    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    EditText Firstname,  Secondname, Birth2, Number2, Weight2, Height2;
    Button  BtnSave;
    SharedPreferences sp;
    String FirstnameStr, SecondnameStr, Birth2Str, Number2Str, Weight2Str, Height2Str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mDisplayDate = (EditText) findViewById(R.id.Birth2);

//        sharedPreference
        Firstname = findViewById(R.id.Firstname);
        Secondname = findViewById(R.id.Secondname);
        Birth2 = findViewById(R.id.Birth2);
        Number2 = findViewById(R.id.Number2);
        Weight2 = findViewById(R.id.Weight2);
        Height2 = findViewById(R.id.Height2);
        BtnSave = findViewById(R.id.BtnSave);
        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);



        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal .get(Calendar.YEAR);
                int month = cal .get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProfileActivity.this,
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



//        BtnSave.setOnClickListener(this);

        BtnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FirstnameStr = Firstname.getText().toString();
                SecondnameStr = Secondname.getText().toString();
                Birth2Str = Birth2.getText().toString();
                Number2Str = Number2.getText().toString();
                Weight2Str = Weight2.getText().toString();
                Height2Str = Height2.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("Firstname", FirstnameStr);
                editor.putString("Secondname", SecondnameStr);
                editor.putString("Birth2", Birth2Str);
                editor.putString("Number2", Number2Str);
                editor.putString("Weight2", Weight2Str);
                editor.putString("Height2", Height2Str);

                editor.commit();

                Toast.makeText(ProfileActivity.this, "Successfully  created a profile", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ProfileActivity.this, ProfActivity.class);
                    startActivity(intent);




            }
        });
        }

    }


