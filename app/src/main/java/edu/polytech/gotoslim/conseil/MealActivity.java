package edu.polytech.gotoslim.conseil;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.conseil.listCreation.Meal;

public class MealActivity extends AppCompatActivity {

    private Meal meal;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recette_activity);
        meal = getIntent().getParcelableExtra("item");
        ((TextView) findViewById(R.id.recipeMeal)).setText(meal.getName());
        ((ImageView) findViewById(R.id.imageMeal)).setImageResource(meal.getPicture());
    }
}