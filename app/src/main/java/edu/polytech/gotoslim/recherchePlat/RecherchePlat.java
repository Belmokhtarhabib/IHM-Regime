package edu.polytech.gotoslim.recherchePlat;

import android.os.Bundle;
import android.view.ViewGroup;

import edu.polytech.gotoslim.Header;
import edu.polytech.gotoslim.R;

public class RecherchePlat extends Header {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ViewGroup vg = (ViewGroup) findViewById(R.id.lldata);
        ViewGroup.inflate(RecherchePlat.this, R.layout.activity_recherche_plat, vg);
    }

}