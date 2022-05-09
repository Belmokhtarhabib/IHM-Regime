package edu.polytech.gotoslim.conseil;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import edu.polytech.gotoslim.Header;
import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.conseil.listCreation.Ilistener;
import edu.polytech.gotoslim.conseil.listCreation.Meal;

public class MealActivity extends AppCompatActivity implements Ilistener {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_recipe);

        Header.setHeader(getSupportFragmentManager());

        this.configureAndShowRecipeFragment();
    }


    private void configureAndShowRecipeFragment(){
        MealRecipe mealRecipe = (MealRecipe) getSupportFragmentManager().findFragmentById(R.id.frame_layout_recipe_meal);

        if (mealRecipe == null) {
            mealRecipe = new MealRecipe();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_recipe_meal, mealRecipe).commit();
        }
    }

    @Override
    public void onClick(Meal item){
    }
}