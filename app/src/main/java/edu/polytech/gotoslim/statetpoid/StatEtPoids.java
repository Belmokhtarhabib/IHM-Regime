package edu.polytech.gotoslim.statetpoid;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.ParametresActivity;
import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.ajoutplat.AjoutPlat;

public class StatEtPoids extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_stat_et_poids);

        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(StatEtPoids.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> startActivity(new Intent(StatEtPoids.this, MainActivity.class)));
    }
}