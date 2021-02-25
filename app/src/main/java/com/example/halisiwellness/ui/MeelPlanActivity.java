package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.example.halisiwellness.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeelPlanActivity extends AppCompatActivity {


    @BindView(R.id.highFibre) CardView mHighFibre;
    @BindView(R.id.glutenFree) CardView mGlutenFree;
    @BindView(R.id.looseWeight) CardView mLooseWeight;
    @BindView(R.id.pregenancyMeal) CardView mPregnancyMeal;
    @BindView(R.id.healthyKids) CardView mHealthyKids;
    @BindView(R.id.lowChorestrarol) CardView mLowCholestrarol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meel_plan);
        ButterKnife.bind(this);

        mHighFibre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeelPlanActivity.this, HighFibreMeal.class);
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
                Intent intent = new Intent(MeelPlanActivity.this, PregnancyMeal.class);
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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}