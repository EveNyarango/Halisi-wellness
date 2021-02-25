package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.halisiwellness.R;

public class DocActivity extends AppCompatActivity {
    TextView textView_n1, textView_n2, textView_n3, textView_n4, textView2;

    Button button_BtnEdit;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_APPOINTMENT = "myapp";
    private static final String KEY_PATIENTNAME = "patientname";
    private static final String KEY_CITY = "city";
    private static final String KEY_PHONE = "phone number";
    private static final String KEY_DATE = "date";

    private static final String KEY_TITLE = "title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        textView2 = findViewById(R.id.textView2);

        textView_n1 = findViewById(R.id.textView_n1);
        textView_n2 = findViewById(R.id.textView_n2);
        textView_n3 = findViewById(R.id.textView_n3);
        textView_n4 = findViewById(R.id.textView_n4);
        button_BtnEdit = findViewById(R.id.button_BtnEdit);


        sharedPreferences  = getApplicationContext().getSharedPreferences(SHARED_PREF_APPOINTMENT, Context.MODE_PRIVATE);
        String patientname = sharedPreferences.getString(KEY_PATIENTNAME, null);
        String city = sharedPreferences.getString(KEY_CITY, null);
        String phone = sharedPreferences.getString(KEY_PHONE, null);
        String date = sharedPreferences.getString(KEY_DATE, null);

        if(patientname != null || city != null || phone != null || date != null) {

            textView_n1.setText( "Patient's Name: "+ patientname);
            textView_n2.setText( "Location: "+ city);
            textView_n3.setText( "Phone number: "+ phone);
            textView_n4.setText("date: "+ date);

        }

        button_BtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(DocActivity.this, " ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}