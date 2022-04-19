package edu.polytech.gotoslim.conseil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import android.widget.ListView;

import edu.polytech.gotoslim.Header;
import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.Parametres;
import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.RecherchePlat;
import edu.polytech.gotoslim.conseil.boisson.Boisson;
import edu.polytech.gotoslim.conseil.boisson.BoissonActivity;
import edu.polytech.gotoslim.conseil.boisson.BoissonAdapter;
import edu.polytech.gotoslim.conseil.boisson.BoissonListActivity;
import edu.polytech.gotoslim.conseil.boisson.ListBoisson;
import edu.polytech.gotoslim.conseil.plat.PlatActivity;
import edu.polytech.gotoslim.conseil.plat.PlatListActivity;

public class ConseilsActivity extends Header {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ViewGroup vg = (ViewGroup) findViewById(R.id.lldata);
        //setContentView(R.layout.activity_conseils);


        ViewGroup.inflate(ConseilsActivity.this, R.layout.activity_conseils, vg);
        findViewById(R.id.boisson).setOnClickListener(v1 -> startActivity(new Intent(ConseilsActivity.this,BoissonListActivity.class)));

        findViewById(R.id.plat).setOnClickListener(v1 -> startActivity(new Intent(ConseilsActivity.this, PlatListActivity.class)));
    }



}