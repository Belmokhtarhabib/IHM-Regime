package edu.polytech.gotoslim;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

public class Parametres extends Header {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ViewGroup vg = (ViewGroup) findViewById(R.id.lldata);
        ViewGroup.inflate(Parametres.this, R.layout.activity_parametres, vg);
    }
}