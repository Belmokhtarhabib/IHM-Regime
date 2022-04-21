package edu.polytech.gotoslim.conseil.listCreation;

import static edu.polytech.gotoslim.conseil.listCreation.MealConst.DRINK;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.R;

public class MealActivity extends AppCompatActivity {

    private Meal meal;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recetteboisson_activity);
        meal = getIntent().getParcelableExtra(DRINK);
        ((TextView) findViewById(R.id.recipeMeal)).setText(meal.getName());
        ((ImageView) findViewById(R.id.imageMeal)).setImageResource(meal.getPicture());
    }



}