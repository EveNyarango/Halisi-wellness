package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.halisiwellness.R;
import com.example.halisiwellness.ui.HighFibreMeal;

import viewholder.HighFibreMealViewHolder;

public class HighFibreAdapter extends ArrayAdapter<String> {
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

    public HighFibreAdapter(Context mContext, String[] mMealsName, String[] mMealsDescription, int[] mMealsImages, String[] mMealsDays) {
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

        HighFibreMealViewHolder holder = null;
        if (singleItem == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.meal_item, parent, false);
            holder = new HighFibreMealViewHolder(singleItem);
            singleItem.setTag(holder);
        }

        else {
            holder = (HighFibreMealViewHolder) singleItem.getTag();
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
