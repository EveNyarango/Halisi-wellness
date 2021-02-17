package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.halisiwellness.R;

public class DiaryActivity extends AppCompatActivity {

    EditText breakfast, lunchy, snacky, supper;
    Button btnDiary;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_BREAK = "break";
    private static final String KEY_LUNCH = "lunch";
    private static final String KEY_SNACK = "snack";
    private static final String KEY_SAPA = "sapa";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        breakfast = findViewById(R.id.breakfast);
        lunchy = findViewById(R.id.lunchy);
        snacky = findViewById(R.id.snacky);
        supper = findViewById(R.id.supper);
        btnDiary = findViewById(R.id.btnDiary);

        sharedPreferences = getSharedPreferences("", MODE_PRIVATE);

        btnDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_BREAK, breakfast.getText().toString());
                editor.putString(KEY_LUNCH, lunchy.getText().toString());
                editor.putString(KEY_SNACK, snacky.getText().toString());
                editor.putString(KEY_SAPA, supper.getText().toString());
                editor.apply();
                Intent intent = new Intent(DiaryActivity.this, Diary2Activity.class);
                startActivity(intent);

                Toast.makeText(DiaryActivity.this, "Diary updated successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}