package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;


import com.example.halisiwellness.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    @BindView(R.id.ProfileImageView)
    ImageView mProfileImageView;
    @BindView(R.id.AppointImageView) ImageView mAppointImageView;
    @BindView(R.id.BlogImageView) ImageView mBlogImageView;
    @BindView(R.id.CalImageView) ImageView mCalImageView;
    @BindView(R.id.DiaryImageView) ImageView mDiaryImageView;
    @BindView(R.id.MealImageView) ImageView mMealImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mProfileImageView.setOnClickListener(this);
        mAppointImageView.setOnClickListener(this);
        mBlogImageView.setOnClickListener(this);
        mCalImageView.setOnClickListener(this);
        mDiaryImageView.setOnClickListener(this);
        mMealImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == mProfileImageView) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        if(v == mAppointImageView) {
            Intent intent = new Intent(MainActivity.this, AppointmentActivity.class);
            startActivity(intent);
        }
        if(v == mBlogImageView) {
            Intent intent = new Intent(MainActivity.this, ArticlesActivity.class);
            startActivity(intent);
        }
        if(v == mCalImageView) {
            Intent intent = new Intent(MainActivity.this, CalenderActivity.class);
            startActivity(intent);
        }
        if(v == mDiaryImageView) {
            Intent intent = new Intent(MainActivity.this, DiaryActivity.class);
            startActivity(intent);
        }
        if(v == mMealImageView) {
            Intent intent = new Intent(MainActivity.this, MeelPlanActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}