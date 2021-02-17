package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.halisiwellness.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeelPlanActivity extends AppCompatActivity {


    @BindView(R.id.highFibre) TextView mHighFibre;
    @BindView(R.id.glutenFree) TextView mGlutenFree;
    @BindView(R.id.looseWeight) TextView mLooseWeight;
    @BindView(R.id.pregenancyMeal) TextView mPregnancyMeal;
    @BindView(R.id.healthyKids) TextView mHealthyKids;
    @BindView(R.id.lowChorestrarol) TextView mLowCholestrarol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meel_plan);
        ButterKnife.bind(this);

        mHighFibre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeelPlanActivity.this,HighFibreMeal.class);
                startActivity(intent);
            }
        });
        mGlutenFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeelPlanActivity.this,GlutenFreeMeal.class);
                startActivity(intent);
            }
        });

        mLooseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeelPlanActivity.this,LooseWeight.class);
                startActivity(intent);
            }
        });

        mPregnancyMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeelPlanActivity.this,PregrancyMeal.class);
                startActivity(intent);
            }
        });
        mHealthyKids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MeelPlanActivity.this, HealthyKidsMeal.class);
                startActivity(intent);
            }
        });
        mLowCholestrarol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MeelPlanActivity.this,LowCholestrarolMeal.class);
                startActivity(intent);
            }
        });
    }
}