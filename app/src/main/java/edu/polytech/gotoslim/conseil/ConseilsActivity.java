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

public class ConseilsActivity extends Header {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ViewGroup vg = (ViewGroup) findViewById(R.id.lldata);
        ViewGroup.inflate(ConseilsActivity.this, R.layout.activity_conseils, vg);
    }



}