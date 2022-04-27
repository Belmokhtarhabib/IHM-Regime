package edu.polytech.gotoslim.conseil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.ParametresActivity;
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

        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(MealActivity.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> {
            startActivity(new Intent(MealActivity.this, MainActivity.class));
            finish();
        });

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