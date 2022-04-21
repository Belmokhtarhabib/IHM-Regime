package edu.polytech.gotoslim.conseil.listCreation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.conseil.listCreation.lists.MealList;

public class MealAdapter extends BaseAdapter {

    private MealList meal;
    private LayoutInflater mInflater;

    public MealAdapter(Context context, MealList meal) {
        this.meal = meal;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return meal.size();
    }
    public Object getItem(int position) {
        return meal.get(position);
    }
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        layoutItem = (LinearLayout) (convertView == null ? mInflater.inflate(R.layout.meal_layout, parent, false) : convertView);

        TextView tvName = layoutItem.findViewById(R.id.Name);
        ImageView picture = layoutItem.findViewById(R.id.Picture);

        tvName.setText(meal.get(position).getName());
        picture.setImageResource(meal.get(position).getPicture());
        return layoutItem;
    }
}