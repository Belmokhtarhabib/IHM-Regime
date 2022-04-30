package edu.polytech.gotoslim.conseil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import edu.polytech.gotoslim.Header;
import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.ParametresActivity;
import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.conseil.listCreation.Ilistener;
import edu.polytech.gotoslim.conseil.listCreation.Meal;

public class MealListActivity extends AppCompatActivity implements Ilistener {
    private String type;
    private boolean isTab = false;
    MealRecipe mealRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_meal);

        Header.setHeader(getSupportFragmentManager());

        this.configureAndShowListMealFragment();

        //only on tablet
        this.configureAndShowMealRecipeFragment();

    }

    @Override
    public void onClick(Meal item){
        if(!isTab){
            Intent intent = new Intent(getApplicationContext(), MealActivity.class);
            intent.putExtra("item", item);
            startActivity(intent);
        }else{
            mealRecipe = new MealRecipe(item);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_recipe_meal, mealRecipe).commit();
        }
    }

    private void configureAndShowListMealFragment(){
        ListMeal listMeal = (ListMeal) getSupportFragmentManager().findFragmentById(R.id.frame_layout_list_meal);

        if (listMeal == null) {
            listMeal = new ListMeal();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_list_meal, listMeal).commit();
        }
    }

    private void configureAndShowMealRecipeFragment(){
        mealRecipe = (MealRecipe) getSupportFragmentManager().findFragmentById(R.id.frame_layout_recipe_meal);
        isTab = findViewById(R.id.frame_layout_recipe_meal) != null;
        //A - We only add DetailFragment in Tablet mode (If found frame_layout_detail)
        if (mealRecipe == null && isTab) {
            mealRecipe = new MealRecipe();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_recipe_meal, mealRecipe)
                    .commit();
        }
    }
}
