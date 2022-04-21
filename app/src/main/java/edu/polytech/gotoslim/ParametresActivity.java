package edu.polytech.gotoslim;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

public class ParametresActivity extends Header {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ViewGroup vg = (ViewGroup) findViewById(R.id.lldata);
        ViewGroup.inflate(ParametresActivity.this, R.layout.activity_parametres, vg);

        ((Button)findViewById(R.id.buttonModifierMonRegime)).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivity.this, ModifierRegimeActivity.class)));
    }
}