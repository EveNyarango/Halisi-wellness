package viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.halisiwellness.R;
import com.github.vipulasri.timelineview.TimelineView;

public class MealsPLanViewHolder extends RecyclerView.ViewHolder {

    public ImageView mealImage;
    public TextView mMealName;
    public TextView mMealDay;
    public TextView mMealDescription;
    public TimelineView mTimelineView;

    public MealsPLanViewHolder(View view, int ViewType){

        super(view);


        mealImage = view.findViewById(R.id.MealImageView);
        mMealDescription =view.findViewById(R.id.Description);
        mMealDay = view.findViewById(R.id.Days);
        mMealName = view.findViewById(R.id.meals);

        // TimeLine
        mTimelineView = (TimelineView) itemView.findViewById(R.id.timeline);
        mTimelineView.initLine(ViewType);
    }

//    @Override
//    public int getItemViewType(int position) {
//        return TimelineView.getTimeLineViewType(position, getItemCount());
//    }
}
