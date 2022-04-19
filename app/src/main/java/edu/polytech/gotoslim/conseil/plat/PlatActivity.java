package edu.polytech.gotoslim.conseil.plat;

import static edu.polytech.gotoslim.conseil.plat.ApplicationPlat.PLAT;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.R;

public class PlatActivity extends AppCompatActivity {

    private Plat plat;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recetteplat_activity);
        plat=getIntent().getParcelableExtra("plat");
        ((TextView) findViewById(R.id.recettePlat)).setText(plat.getName());
        ((ImageView) findViewById(R.id.imagePlat)).setImageResource(plat.getPicture());

        ((Button) findViewById(R.id.buttonPlat)).setOnClickListener(click -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("PLAT");
            builder.setMessage("vous avez cliqué sur: " + plat);
            builder.setNeutralButton("OK", null);
            builder.show();
        });


    }



}
