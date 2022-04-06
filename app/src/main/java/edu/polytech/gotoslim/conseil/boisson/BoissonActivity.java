package edu.polytech.gotoslim.conseil.boisson;

import static edu.polytech.gotoslim.conseil.boisson.ApplicationBoisson.BOISSON;

import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.R;

public class BoissonActivity extends AppCompatActivity {

    private Boisson boisson;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recetteboisson_activity);
        boisson=getIntent().getParcelableExtra(BOISSON);
        ((TextView) findViewById(R.id.recetteBoisson)).setText(boisson.getName());
        ((ImageView) findViewById(R.id.imageBoisson)).setImageResource(boisson.getPicture());
    }



}
