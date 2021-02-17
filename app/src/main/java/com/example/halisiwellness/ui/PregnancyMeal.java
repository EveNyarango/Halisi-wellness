package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.halisiwellness.R;

import adapter.MealsPlanAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PregnancyMeal extends AppCompatActivity {

    @BindView(R.id.pregnancyMealListView)
    ListView mPregnancyListView;

    String[]  mMealsName = {"Vegan Minestrone","Chicken Parmesan","Chickpea Dumplings","Mediterranean stew"};
    String[]  mMealsDescription = {"This vegan minestrone soup is heavy on the green vegetables (it has peas, zucchini and kale, to name a few!), setting this quick healthy soup","Chicken Parm gets a fun low-carb and gluten-free twist with these cheesy stuffed peppers with chicken and quinoa.","spinach and artichoke dip, this creamy pasta is for you. And here's what's almost as good as the flavor of this comforting dish: the fact that this healthy dinner takes just 20 minutes to prepare.","chickpea-flour dumplings with chiles and greens. Serve with naan to sop up the sauce for a healthy vegetarian dinner with plenty of protein.","Mediterranean stew is a healthy dinner chock-full of vegetables and hearty chickpeas. A drizzle of olive oil to finish carries the flavors of this easy vegan crock-pot stew."};
    String[]  mMealsDays = {"Day 1","Day 2","Day 3","Day 4","Day 5"};

    int[]  mMealsImages = {R.drawable.looseweight,R.drawable.healthykids,R.drawable.lowcholestrarol,R.drawable.pregnancy,R.drawable.meals,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregrancy_meal);
        ButterKnife.bind(this);

        MealsPlanAdapter mealsPlanAdapter = new MealsPlanAdapter(this, mMealsName,mMealsDescription,mMealsImages,mMealsDays);
        mPregnancyListView.setAdapter(mealsPlanAdapter);


    }
}