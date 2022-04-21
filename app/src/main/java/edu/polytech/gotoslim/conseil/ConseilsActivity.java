package edu.polytech.gotoslim.conseil;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import edu.polytech.gotoslim.Header;
import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.conseil.activities.DrinkListActivity;
import edu.polytech.gotoslim.conseil.activities.PlatListActivity;

public class ConseilsActivity extends Header {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ViewGroup vg = (ViewGroup) findViewById(R.id.lldata);
        //setContentView(R.layout.activity_conseils);


        ViewGroup.inflate(ConseilsActivity.this, R.layout.activity_conseils, vg);
        findViewById(R.id.boisson).setOnClickListener(v1 -> startActivity(new Intent(ConseilsActivity.this, DrinkListActivity.class)));

        findViewById(R.id.plat).setOnClickListener(v1 -> startActivity(new Intent(ConseilsActivity.this, PlatListActivity.class)));
    }



}