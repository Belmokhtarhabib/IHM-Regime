package edu.polytech.gotoslim.conseil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.ParametresActivity;
import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.ajoutplat.AjoutPlat;
import edu.polytech.gotoslim.conseil.listCreation.Meal;

public class MealActivity extends AppCompatActivity {

    private Meal meal;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.recette_activity);

        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(MealActivity.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> startActivity(new Intent(MealActivity.this, MainActivity.class)));
        meal = getIntent().getParcelableExtra("item");
        ((TextView) findViewById(R.id.recipeMeal)).setText(meal.getName());
        ((ImageView) findViewById(R.id.imageMeal)).setImageResource(meal.getPicture());
    }
}