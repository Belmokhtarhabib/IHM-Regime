package edu.polytech.gotoslim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.ajoutplat.AjoutPlat;

public class ParametresActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_parametres);

        findViewById(R.id.settings).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivity.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivity.this, MainActivity.class)));

        ((Button) findViewById(R.id.buttonModifierMonRegime)).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivity.this, ModifierRegimeActivity.class)));
        ((Switch) findViewById(R.id.ModeSombre)).setOnClickListener(v1 -> startActivity(new Intent(ParametresActivity.this,ParametresActivityBlack.class )));

        Switch switch1 = (Switch) findViewById(R.id.ModeSombre);
        Switch switch2 = (Switch) findViewById(R.id.ModeSombre_black);


        /**switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked2 =((Switch) v).isChecked();
                boolean checked = ((Switch) v).isChecked();
                if (checked) {
                    setContentView(R.layout.activity_parametres_black);
                }
                if(!checked){
                    setContentView(R.layout.activity_parametres);
                }

            }
        });**/
    }
}

