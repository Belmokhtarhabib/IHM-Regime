package edu.polytech.gotoslim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;

import java.util.Objects;

public class ParametresActivityBlack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_parametres_black);

        Header.setHeader(getSupportFragmentManager());

        ((Button) findViewById(R.id.buttonModifierMonRegime)).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivityBlack.this, ModifierRegimeActivity.class)));
        ((Switch) findViewById(R.id.ModeSombre_black)).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivityBlack.this, ParametresActivity.class)));
    }
}
