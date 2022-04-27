package edu.polytech.gotoslim;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.ajoutplat.AjoutPlat;

public class Suivi extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_suivi);

        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(Suivi.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> {
            startActivity(new Intent(Suivi.this, MainActivity.class));
            finish();
        });
    }
}