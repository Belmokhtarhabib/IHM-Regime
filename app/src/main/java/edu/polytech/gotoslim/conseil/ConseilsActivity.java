package edu.polytech.gotoslim.conseil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;

import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.RecherchePlat;
import edu.polytech.gotoslim.conseil.boisson.Boisson;
import edu.polytech.gotoslim.conseil.boisson.BoissonActivity;
import edu.polytech.gotoslim.conseil.boisson.BoissonAdapter;
import edu.polytech.gotoslim.conseil.boisson.BoissonListActivity;
import edu.polytech.gotoslim.conseil.boisson.ListBoisson;

public class ConseilsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conseils);
        findViewById(R.id.boisson).setOnClickListener(v1 -> startActivity(new Intent(ConseilsActivity.this, BoissonListActivity.class)));

    }



}