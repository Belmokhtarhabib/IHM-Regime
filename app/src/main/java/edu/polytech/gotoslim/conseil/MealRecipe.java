package edu.polytech.gotoslim.conseil;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.conseil.listCreation.Ilistener;
import edu.polytech.gotoslim.conseil.listCreation.Meal;
import edu.polytech.gotoslim.conseil.listCreation.MealAdapter;
import edu.polytech.gotoslim.conseil.listCreation.lists.FactoryList;
import edu.polytech.gotoslim.conseil.listCreation.lists.MealList;

public class MealRecipe extends Fragment implements Ilistener {

    private Ilistener mCallback;
    Meal meal = null;

    public MealRecipe() {
    }

    public MealRecipe(Meal meal) {
        this.meal = meal;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result= inflater.inflate(R.layout.fragment_meal_recipe, container, false);

        if(meal == null) meal = requireActivity().getIntent().getParcelableExtra("item");
        if(meal!=null) {
            ((TextView) result.findViewById(R.id.recipeMeal)).setText(meal.getRecipe());
            ((ImageView) result.findViewById(R.id.imageMeal)).setImageResource(meal.getPicture());
        }
        return result;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.createCallbackToParentActivity();
    }

    private void createCallbackToParentActivity(){
        try {
            mCallback = (Ilistener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }

    @Override
    public void onClick(Meal item) {
        mCallback.onClick(item);
    }
}