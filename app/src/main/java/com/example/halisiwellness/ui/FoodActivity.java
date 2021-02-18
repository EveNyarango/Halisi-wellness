package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.halisiwellness.R;

public class FoodActivity extends AppCompatActivity {

    TextView textView_breakfast2, textView_lunchy2, textView_snacky2, textView_sapa2, textView_Date;
    Button button_btnBack;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_BREAKY = "breaky";
    private static final String KEY_LUNCH = "lunch";
    private static final String KEY_SNACK = "snack";
    private static final String KEY_SAPA = "sapa";
    private static final String KEY_DATE = "date";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        textView_breakfast2 = findViewById(R.id.textView_breakfast2);
        textView_lunchy2 = findViewById(R.id.textView_lunchy2);
       textView_snacky2 = findViewById(R.id.textView_snacky2);
        textView_sapa2 = findViewById(R.id.textView_sapa2);
        textView_Date =findViewById(R.id.textView_date);
        button_btnBack = findViewById(R.id.button_btnBack);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String breaky =sharedPreferences.getString(KEY_BREAKY, null);
        String lunch =sharedPreferences.getString(KEY_LUNCH, null);
        String snack =sharedPreferences.getString(KEY_SNACK, null);
        String sapa =sharedPreferences.getString(KEY_SAPA, null);
        String date = sharedPreferences.getString(KEY_DATE, null);

        if (breaky !=null || lunch !=null || snack !=null || sapa !=null || date !=null){
            textView_breakfast2.setText("Breakfast: " + breaky);
            textView_lunchy2.setText("Lunch: " + lunch);
            textView_snacky2.setText("Snack: " + snack);
            textView_sapa2.setText("Supper: " + sapa);
            textView_Date.setText("Date: " + date);
        }
button_btnBack.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        finish();
        Toast.makeText(FoodActivity.this, "Good. Keep Tracking", Toast.LENGTH_SHORT).show();
    }
});



    }
}