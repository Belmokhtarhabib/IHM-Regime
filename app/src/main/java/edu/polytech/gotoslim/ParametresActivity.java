package edu.polytech.gotoslim;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ParametresActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_parametres);

        Header.setHeader(getSupportFragmentManager());

        ((Button) findViewById(R.id.buttonModifierMonRegime)).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivity.this, ModifierRegimeActivity.class)));
        ((Switch) findViewById(R.id.ModeSombre)).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivity.this,ParametresActivityBlack.class )));
    }
}

