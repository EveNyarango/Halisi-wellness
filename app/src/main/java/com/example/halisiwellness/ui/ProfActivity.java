package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.halisiwellness.R;

public class ProfActivity extends AppCompatActivity {
    TextView textView_t1, textView_t2, textView_t3, textView_t4, textView_t5, textView_t6;
//    ImageView mProfileImage;
    Button button_BtnEdit;
            SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_PROFILE = "mypref";
    private static final String KEY_FIRSTNAME = "firstname";
    private static final String KEY_SECONDNAME = "secondname";
    private static final String KEY_BIRTH2 = "birth2";
    private static final String KEY_NUMBER2 = "number2";
    private static final String KEY_WEIGHT2 = "weight2";
    private static final String KEY_HEIGHT2 = "height2";
//    private static  final String KEY_PROFILEIMAGE = "mProfileImage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof);

        textView_t1 = findViewById(R.id.textView_t1);
        textView_t2 = findViewById(R.id.textView_t2);
        textView_t3 = findViewById(R.id.textView_t3);
       textView_t4 = findViewById(R.id.textView_t4);
        textView_t5 = findViewById(R.id.textView_t5);
        textView_t6 = findViewById(R.id.textView_t6);
        button_BtnEdit = findViewById(R.id.button_BtnEdit);
//        mProfileImage = findViewById(R.id.ProfileImage);

        sharedPreferences  = getApplicationContext().getSharedPreferences(SHARED_PREF_PROFILE, Context.MODE_PRIVATE);
        String firstname = sharedPreferences.getString(KEY_FIRSTNAME, null);
        String secondname = sharedPreferences.getString(KEY_SECONDNAME, null);
        String birth2 = sharedPreferences.getString(KEY_BIRTH2, null);
        String number2 =sharedPreferences.getString(KEY_NUMBER2, null);
        String weight2 =sharedPreferences.getString(KEY_WEIGHT2, null);
        String height2 = sharedPreferences.getString(KEY_HEIGHT2, null);
//        String ProfileImage = sharedPreferences.getString(KEY_PROFILEIMAGE, null);

        if(firstname !=null || secondname !=null || birth2 !=null || number2 !=null || weight2 !=null || height2 !=null) {

            textView_t1.setText( "Firstname: "+ firstname);
            textView_t2.setText( "Secondname: "+ secondname);
            textView_t3.setText( "D.O.B: "+ birth2);
            textView_t4.setText( "Phone number: "+ number2);
            textView_t5.setText( "Height: "+ height2);
            textView_t6.setText( "Weight: "+ weight2);

        }

        button_BtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(ProfActivity.this, "Good. Keep Tracking", Toast.LENGTH_SHORT).show();
            }
        });
    }
}