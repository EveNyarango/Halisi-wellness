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

    EditText editText_Firstname,  editText_Secondname, editText_Birth2, editText_Number2, editText_Weight2, editText_Height2;
    Button  button_BtnSave;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_PROFILE = "mypref";
    private static final String KEY_FIRSTNAME = "firstname";
    private static final String KEY_SECONDNAME = "secondname";
    private static final String KEY_BIRTH2 = "birth2";
    private static final String KEY_NUMBER2 = "number2";
    private static final String KEY_WEIGHT2 = "weight2";
    private static final String KEY_HEIGHT2 = "height2";
//    String FirstnameStr, SecondnameStr, Birth2Str, Number2Str, Weight2Str, Height2Str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mDisplayDate = (EditText) findViewById(R.id.editText_Birth2);

//        sharedPreference
        editText_Firstname = findViewById(R.id.editText_Firstname);
        editText_Secondname = findViewById(R.id.editText_Secondname);
        editText_Birth2 = findViewById(R.id.editText_Birth2);
        editText_Number2 = findViewById(R.id.editText_Number2);
        editText_Weight2 = findViewById(R.id.editText_Weight2);
        editText_Height2 = findViewById(R.id.editText_Height2);
        button_BtnSave = findViewById(R.id.button_BtnSave);
        sharedPreferences = getSharedPreferences(SHARED_PREF_PROFILE,MODE_PRIVATE);

        String firstname = sharedPreferences.getString(KEY_FIRSTNAME, null);

        if(firstname !=null){
            Intent intent = new Intent(ProfileActivity.this, ProfActivity.class);
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

        button_BtnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(KEY_FIRSTNAME, editText_Firstname.getText().toString());
                editor.putString(KEY_SECONDNAME, editText_Secondname.getText().toString());
                editor.putString(KEY_BIRTH2, editText_Birth2.getText().toString());
                editor.putString(KEY_NUMBER2, editText_Number2.getText(). toString());
                editor.putString(KEY_WEIGHT2, editText_Weight2.getText().toString());
                editor.putString(KEY_HEIGHT2, editText_Height2.getText().toString());

                editor.apply();

                Toast.makeText(ProfileActivity.this, "Successfully  created a profile", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ProfileActivity.this, ProfActivity.class);
                    startActivity(intent);




            }
        });
        }

    }


