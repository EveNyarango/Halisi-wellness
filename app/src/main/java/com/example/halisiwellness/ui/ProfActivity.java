package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.halisiwellness.R;

public class ProfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof);

        TextView t1, t2, t3, t4, t5, t6;
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String Firstname = sp.getString("t1", " ");
        String Secondname = sp.getString("t2", " ");
        String Birth2 = sp.getString("t3", " ");
        String Number2 = sp.getString("t4", " ");
        String Weight2 = sp.getString("t5", " ");
        String Height2 = sp.getString("t6", " ");

        t1.setText(Firstname);
        t2.setText(Secondname);
        t3.setText(Birth2);
        t4.setText(Number2);
        t5.setText(Weight2);
        t6.setText(Height2);

    }
}