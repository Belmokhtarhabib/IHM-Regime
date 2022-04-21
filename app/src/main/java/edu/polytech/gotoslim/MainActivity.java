package edu.polytech.gotoslim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Window;
import android.os.Bundle;

import edu.polytech.gotoslim.conseil.ConseilsActivity;
import android.widget.ProgressBar;

import edu.polytech.gotoslim.recherchePlat.RecherchePlat;
import edu.polytech.gotoslim.statetpoid.StatEtPoids;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(MainActivity.this, ParametresActivity.class)));

        findViewById(R.id.recherchePlat).setOnClickListener(v1 -> startActivity(new Intent(MainActivity.this, RecherchePlat.class)));

        findViewById(R.id.conseils).setOnClickListener(v1 -> startActivity(new Intent(MainActivity.this, ConseilsActivity.class)));

        findViewById(R.id.suivi).setOnClickListener(v1 -> startActivity(new Intent(MainActivity.this,Suivi.class)));

        findViewById(R.id.statsEtPoids).setOnClickListener(v1 -> startActivity(new Intent(MainActivity.this, StatEtPoids.class)));

        findViewById(R.id.succes).setOnClickListener(v1 -> startActivity(new Intent(MainActivity.this,Succes.class)));

        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setProgress(90);
    }
}