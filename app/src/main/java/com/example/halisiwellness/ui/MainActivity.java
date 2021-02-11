package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.halisiwellness.R;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ProfileImageView)
    ImageView mProfileImageView;
    @BindView(R.id.AppointImageView) ImageView mAppointImageView;
    @BindView(R.id.BlogImageView) ImageView mBlogImageView;
    @BindView(R.id.CalImageView) ImageView mCalImageView;
    @BindView(R.id.DiaryImageView) ImageView mDiaryImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}