package com.example.halisiwellness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.halisiwellness.ui.LoginActivity;
import com.example.halisiwellness.ui.MainActivity;

public class AnimActivity extends Activity {



    private static  int SPLASH_TIME_OUT = 5000;

    //Hooks

    View first,second,third,fourth,fifth,sixth;
    TextView a, slogan;

    //Animation variables

    Animation topAnimation, bottomAnimation, middleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.activity_bottom);
        bottomAnimation = AnimationUtils.loadAnimation(this,R. anim.activity_middle);
        middleAnimation = AnimationUtils.loadAnimation(this, R.anim.activity_top);

        //Hooks

        first = findViewById(R.id.first_line);
        second = findViewById(R.id.second_line);
        third = findViewById(R.id.third_line);
        fourth = findViewById(R.id.fourth_line);
        fifth = findViewById(R.id.fifth_line);
        sixth = findViewById(R.id.sixth_line);

        a = findViewById(R.id.a);
        slogan = findViewById(R.id.tagLine);

        //Setting animations

        first.setAnimation(topAnimation);
        second.setAnimation(topAnimation);
        third.setAnimation(topAnimation);
        fourth.setAnimation(topAnimation);
        fifth.setAnimation(topAnimation);
        sixth.setAnimation(topAnimation);

        a.setAnimation(middleAnimation);
        slogan.setAnimation(bottomAnimation);

        //Splash screen

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (AnimActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}
