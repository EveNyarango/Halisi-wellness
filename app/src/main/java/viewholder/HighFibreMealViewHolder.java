package viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.halisiwellness.R;

public class HighFibreMealViewHolder {

    public ImageView mealImage;
    public TextView mMealName;
    public TextView mMealDay;
    public TextView mMealDescription;

    public HighFibreMealViewHolder(View view){

        mealImage = view.findViewById(R.id.MealImageView);
        mMealDescription =view.findViewById(R.id.Description);
        mMealDay = view.findViewById(R.id.Days);
        mMealName = view.findViewById(R.id.meals);
    }
}
