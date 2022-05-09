package edu.polytech.gotoslim.recherchePlat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

import edu.polytech.gotoslim.Header;

public class AfficherPlatActivity extends AppCompatActivity {

    private JSONObject itemRecup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Header.setHeader(getSupportFragmentManager());
    }

    public void setItemRecup(JSONObject itemRecup) {
        this.itemRecup = itemRecup;
    }
}