package edu.polytech.gotoslim.conseil.activities;

import static edu.polytech.gotoslim.conseil.listCreation.MealConst.MAIN_COURSE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.conseil.listCreation.Ilistener;
import edu.polytech.gotoslim.conseil.listCreation.Meal;
import edu.polytech.gotoslim.conseil.listCreation.MealActivity;
import edu.polytech.gotoslim.conseil.listCreation.MealAdapter;
import edu.polytech.gotoslim.conseil.listCreation.lists.FactoryList;
import edu.polytech.gotoslim.conseil.listCreation.lists.MealList;

public class PlatListActivity extends AppCompatActivity implements Ilistener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        MealList meals = (new FactoryList()).createList(MAIN_COURSE);

        MealAdapter adapter = new MealAdapter(getApplicationContext(), meals);

        ListView list = findViewById(R.id.listViewMeal);

        list.setAdapter(adapter);
    }

    @Override
    public void onClick(Meal item){
        Intent intent = new Intent(getApplicationContext(), MealActivity.class);
        intent.putExtra(MAIN_COURSE, item);
        startActivity(intent);
    }
}
