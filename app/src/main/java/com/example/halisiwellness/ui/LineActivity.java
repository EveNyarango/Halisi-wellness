package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
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

public class LineActivity extends AppCompatActivity {


    Button button_btnDiary2, button_btnDate;
    EditText editText_meal1, editText_quantity1, editText_units1, editText_calories1, editText_meal2, editText_quantity2, editText_units2, editText_calories2, editText_meal3, editText_quantity3, editText_units3, editText_calories3,editText_meal4, editText_quantity4, editText_units4, editText_calories4;

    private Button mDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);

        mDate = (Button) findViewById(R.id.button_btnDate);
        button_btnDiary2 = findViewById(R.id.button_btnDiary2);
        editText_meal1 = findViewById(R.id.editText_meal1);
        editText_quantity1 = findViewById(R.id.editText_quantity1);
        editText_units1 = findViewById(R.id.editText_units1);
        editText_calories1 = findViewById(R.id.editText_calories1);

        editText_meal2 = findViewById(R.id.editText_meal2);
        editText_quantity2 = findViewById(R.id.editText_quantity2);
        editText_units2 = findViewById(R.id.editText_units2);
        editText_calories2 = findViewById(R.id.editText_calories2);

        editText_meal3 = findViewById(R.id.editText_meal3);
        editText_quantity3 = findViewById(R.id.editText_quantity3);
        editText_units3 = findViewById(R.id.editText_units3);
        editText_calories3 = findViewById(R.id.editText_calories3);

        editText_meal4 = findViewById(R.id.editText_meal4);
        editText_quantity4 = findViewById(R.id.editText_quantity4);
        editText_units4 = findViewById(R.id.editText_units4);
        editText_calories4 = findViewById(R.id.editText_calories4);


//        DATE
        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal .get(Calendar.YEAR);
                int month = cal .get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        LineActivity.this,
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

        button_btnDiary2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LineActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(LineActivity.this, "Good work! You have successfully submitted today's food diary!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}