package edu.polytech.gotoslim.recherchePlat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.ParametresActivity;
import edu.polytech.gotoslim.ajoutplat.AjoutPlat;

import edu.polytech.gotoslim.R;

public class RecherchePlat extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_recherche_plat);

        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(RecherchePlat.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> startActivity(new Intent(RecherchePlat.this, MainActivity.class)));

        findViewById(R.id.ajoutplat).setOnClickListener(v1 -> startActivity(new Intent(RecherchePlat.this, AjoutPlat.class)));

    }

}