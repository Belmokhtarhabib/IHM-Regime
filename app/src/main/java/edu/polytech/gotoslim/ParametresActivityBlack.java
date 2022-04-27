package edu.polytech.gotoslim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;

public class ParametresActivityBlack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_parametres_black);

        findViewById(R.id.settings).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivityBlack.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> {
            startActivity(new Intent(ParametresActivityBlack.this, MainActivity.class));
            finish();
        });

        ((Button) findViewById(R.id.buttonModifierMonRegime)).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivityBlack.this, ModifierRegimeActivity.class)));
        ((Switch) findViewById(R.id.ModeSombre_black)).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivityBlack.this, ParametresActivity.class)));
        Switch switch1 = (Switch) findViewById(R.id.ModeSombre);
        Switch switch2 = (Switch) findViewById(R.id.ModeSombre_black);

        /**
         switch1.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        boolean checked2 =((Switch) v).isChecked();
        boolean checked = ((Switch) v).isChecked();
        if (checked2) {
        setContentView(R.layout.activity_parametres_black);
        }
        if(!checked2){
        setContentView(R.layout.activity_parametres);
        }

        }
        });**/
    }
}
