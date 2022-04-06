package edu.polytech.gotoslim.statetpoid;

import android.os.Bundle;
import android.view.ViewGroup;

import edu.polytech.gotoslim.Header;
import edu.polytech.gotoslim.R;

public class StatEtPoids extends Header {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ViewGroup vg = (ViewGroup) findViewById(R.id.lldata);
        ViewGroup.inflate(StatEtPoids.this, R.layout.activity_stat_et_poids, vg);
    }
}