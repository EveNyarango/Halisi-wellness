package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.halisiwellness.R;

import java.util.Calendar;

public class DiaryActivity extends AppCompatActivity {

    EditText editText_breakfast, editText_lunchy, editText_snacky, editText_supper;
    Button button_btnDiary, button_btnDate;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_BREAKY = "breaky";
    private static final String KEY_LUNCH = "lunch";
    private static final String KEY_SNACK = "snack";
    private static final String KEY_SAPA = "sapa";
    private static final String KEY_DATE = "date";

    private Button mDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        mDate = (Button) findViewById(R.id.button_btnDate);

        editText_breakfast = findViewById(R.id.editText_breakfast);
     editText_lunchy = findViewById(R.id.editText_lunchy);
        editText_snacky = findViewById(R.id.editText_snacky);
        editText_supper = findViewById(R.id.editText_supper);
        button_btnDiary = findViewById(R.id.button_btnDiary);
        button_btnDate = findViewById(R.id.button_btnDate);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String breaky = sharedPreferences.getString(KEY_BREAKY, null);

        if(breaky !=null){
            Intent intent = new Intent(DiaryActivity.this, FoodActivity.class);
            startActivity(intent);
        }

//        DATE
        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal .get(Calendar.YEAR);
                int month = cal .get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DiaryActivity.this,
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
//                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDate.setText(date);

            }
        };


        button_btnDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_BREAKY, editText_breakfast.getText().toString());
                editor.putString(KEY_LUNCH, editText_lunchy.getText().toString());
                editor.putString(KEY_SNACK, editText_snacky.getText().toString());
                editor.putString(KEY_SAPA, editText_supper.getText().toString());
                editor.putString(KEY_DATE, button_btnDate.getText().toString());
                editor.apply();
                Intent intent = new Intent(DiaryActivity.this, FoodActivity.class);
                startActivity(intent);

                Toast.makeText(DiaryActivity.this, "Food Diary updated successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}