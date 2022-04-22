package edu.polytech.gotoslim;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.ajoutplat.AjoutPlat;

public class ParametresActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_parametres);

        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(ParametresActivity.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> startActivity(new Intent(ParametresActivity.this, MainActivity.class)));

        ((Button)findViewById(R.id.buttonModifierMonRegime)).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivity.this, ModifierRegimeActivity.class)));
    }
}