package edu.polytech.gotoslim.recherchePlat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

public class AfficherPlatActivity extends AppCompatActivity {

    private JSONObject itemRecup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setItemRecup(JSONObject itemRecup) {
        this.itemRecup = itemRecup;
    }
}