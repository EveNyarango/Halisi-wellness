package com.example.halisiwellness.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.halisiwellness.R;

import viewholder.MealsPLanViewHolder;

public class MealsPlanAdapter extends ArrayAdapter<String> {
    Context mContext;
    int[] mImages;
    String[] mMealsName;
    String[] mMealsDays;
    String[] mMealsDescription;

//    public HighFibreAdapter(Context mContext, int[] mImages, String[] mMealsName, String[] mMealsDays, String[] mMealsDescription) {
//        super(mContext, R.layout.meal_item,R.id.meals,mMealsName);
//        this.mContext = mContext;
//        this.mImages = mImages;
//        this.mMealsDescription = mMealsDescription;
//        this.mMealsDays = mMealsDays;
//        this.mMealsName = mMealsName;
//
//    }

    public MealsPlanAdapter(Context mContext, String[] mMealsName, String[] mMealsDescription, int[] mMealsImages, String[] mMealsDays) {
        super(mContext, R.layout.meal_item,R.id.meals,mMealsName);
        this.mContext = mContext;
        this.mMealsName = mMealsName;
        this.mMealsDescription = mMealsDescription;
        this.mMealsDays = mMealsDays;
        this.mImages = mMealsImages;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View singleItem = convertView;

        MealsPLanViewHolder holder = null;
        if (singleItem == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.meal_item, parent, false);
            holder = new MealsPLanViewHolder(singleItem);
            singleItem.setTag(holder);
        }

        else {
            holder = (MealsPLanViewHolder) singleItem.getTag();
        }

        holder.mealImage.setImageResource(mImages[position]);
        holder.mMealName.setText(mMealsName[position]);
        holder.mMealDescription.setText(mMealsDescription[position]);
        holder.mMealDay.setText(mMealsDays[position]);
        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You clicked" + mMealsName, Toast.LENGTH_SHORT).show();
            }
        });
        return singleItem;
    }
}
