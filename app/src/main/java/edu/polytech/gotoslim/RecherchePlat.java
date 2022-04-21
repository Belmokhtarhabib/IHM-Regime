package edu.polytech.gotoslim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import edu.polytech.gotoslim.ajoutplat.AjoutPlat;

public class RecherchePlat extends Header {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ViewGroup vg = (ViewGroup) findViewById(R.id.lldata);
        ViewGroup.inflate(RecherchePlat.this, R.layout.activity_recherche_plat, vg);

        findViewById(R.id.ajoutplat).setOnClickListener(v1 -> startActivity(new Intent(RecherchePlat.this, AjoutPlat.class)));

    }
}