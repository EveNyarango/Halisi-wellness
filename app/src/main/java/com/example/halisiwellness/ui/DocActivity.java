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
    TextView textView_n1, textView_n2, textView_n3, textView_n4;

    Button button_BtnEdit;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_APPOINTMENT = "myapp";
    private static final String KEY_PATIENTNAME = "patientname";
    private static final String KEY_CITY = "city";
    private static final String KEY_PHONE = "phone number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        textView_n1 = findViewById(R.id.textView_n1);
        textView_n2 = findViewById(R.id.textView_n2);
        textView_n3 = findViewById(R.id.textView_n3);
        textView_n4 = findViewById(R.id.textView_n4);
        button_BtnEdit = findViewById(R.id.button_BtnEdit);


        sharedPreferences  = getApplicationContext().getSharedPreferences(SHARED_PREF_APPOINTMENT, Context.MODE_PRIVATE);
        String patientname = sharedPreferences.getString(KEY_PATIENTNAME, null);
        String city = sharedPreferences.getString(KEY_CITY, null);
        String phone = sharedPreferences.getString(KEY_PHONE, null);

        if(patientname != null || city != null || phone != null) {

            textView_n1.setText( "Patient's Name: "+ patientname);
            textView_n2.setText( "Location: "+ city);
            textView_n3.setText( "Phone number: "+ phone);

        }

        button_BtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(DocActivity.this, "Our admin team will reach out to you for further notifications ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}