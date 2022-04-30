package edu.polytech.gotoslim.conseil;

import static edu.polytech.gotoslim.conseil.listCreation.MealConst.DESERT;
import static edu.polytech.gotoslim.conseil.listCreation.MealConst.DRINK;
import static edu.polytech.gotoslim.conseil.listCreation.MealConst.MAIN_COURSE;
import static edu.polytech.gotoslim.conseil.listCreation.MealConst.STARTER;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.Header;
import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.ParametresActivity;
import edu.polytech.gotoslim.R;

public class ConseilsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_conseils);

        Header.setHeader(getSupportFragmentManager());

        findViewById(R.id.boisson).setOnClickListener(v1 -> launchActivity(DRINK));
        findViewById(R.id.plat).setOnClickListener(v1 -> launchActivity(MAIN_COURSE));
        findViewById(R.id.dessert).setOnClickListener(v1 -> launchActivity(DESERT));
        findViewById(R.id.entrée).setOnClickListener(v1 -> launchActivity(STARTER));
    }

    void launchActivity(String type){
        Intent i = new Intent(ConseilsActivity.this, MealListActivity.class);
        i.putExtra("typeMeal", type);
        startActivity(i);
    }
}