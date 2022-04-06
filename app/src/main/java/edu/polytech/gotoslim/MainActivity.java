package edu.polytech.gotoslim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.recherchePlat).setOnClickListener(v1 -> startActivity(new Intent(MainActivity.this,RecherchePlat.class)));

        findViewById(R.id.conseils).setOnClickListener(v1 -> startActivity(new Intent(MainActivity.this,Conseils.class)));

        findViewById(R.id.suivi).setOnClickListener(v1 -> startActivity(new Intent(MainActivity.this,Suivi.class)));

        findViewById(R.id.statsEtPoids).setOnClickListener(v1 -> startActivity(new Intent(MainActivity.this,StatEtPoids.class)));

        findViewById(R.id.succes).setOnClickListener(v1 -> startActivity(new Intent(MainActivity.this,Succes.class)));

    }
}