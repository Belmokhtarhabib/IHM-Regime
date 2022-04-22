package edu.polytech.gotoslim.conseil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Window;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.ParametresActivity;
import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.Suivi;
import edu.polytech.gotoslim.conseil.listCreation.Ilistener;
import edu.polytech.gotoslim.conseil.listCreation.Meal;
import edu.polytech.gotoslim.conseil.listCreation.MealAdapter;
import edu.polytech.gotoslim.conseil.listCreation.lists.FactoryList;
import edu.polytech.gotoslim.conseil.listCreation.lists.MealList;

public class MealListActivity extends AppCompatActivity implements Ilistener {
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_meal);

        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(MealListActivity.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> startActivity(new Intent(MealListActivity.this, MainActivity.class)));

        type = getIntent().getStringExtra("typeMeal");
        MealList meals = (new FactoryList()).createList(type);

        MealAdapter adapter = new MealAdapter(getApplicationContext(), meals);

        ListView list = findViewById(R.id.listViewMeal);

        list.setAdapter(adapter);

        adapter.addListener(this);
    }

    @Override
    public void onClick(Meal item){
        Intent intent = new Intent(getApplicationContext(), MealActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }
}
