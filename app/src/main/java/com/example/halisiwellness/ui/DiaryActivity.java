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

    EditText editText_breakfast, editText_lunchy, editText_snacky, editText_supper;
    Button button_btnDiary;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_BREAKY = "breaky";
    private static final String KEY_LUNCH = "lunch";
    private static final String KEY_SNACK = "snack";
    private static final String KEY_SAPA = "sapa";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        editText_breakfast = findViewById(R.id.editText_breakfast);
     editText_lunchy = findViewById(R.id.editText_lunchy);
        editText_snacky = findViewById(R.id.editText_snacky);
        editText_supper = findViewById(R.id.editText_supper);
        button_btnDiary = findViewById(R.id.button_btnDiary);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String breaky = sharedPreferences.getString(KEY_BREAKY, null);

        if(breaky !=null){
            Intent intent = new Intent(DiaryActivity.this, Diary2Activity.class);
            startActivity(intent);
        }

        button_btnDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_BREAKY, editText_breakfast.getText().toString());
                editor.putString(KEY_LUNCH, editText_lunchy.getText().toString());
                editor.putString(KEY_SNACK, editText_snacky.getText().toString());
                editor.putString(KEY_SAPA, editText_supper.getText().toString());
                editor.apply();
                Intent intent = new Intent(DiaryActivity.this, Diary2Activity.class);
                startActivity(intent);

                Toast.makeText(DiaryActivity.this, "Food Diary updated successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}