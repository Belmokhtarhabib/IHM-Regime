package edu.polytech.gotoslim.recherchePlat;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Objects;

import edu.polytech.gotoslim.Header;
import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.ParametresActivity;
import edu.polytech.gotoslim.RequestApi.ApiRecette;
import edu.polytech.gotoslim.RequestApi.Plat;
import edu.polytech.gotoslim.ajoutplat.AjoutPlat;

import edu.polytech.gotoslim.R;

public class RecherchePlat extends AppCompatActivity {

    public JSONObject json;
    public Plat plat;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_recherche_plat);

        Header.setHeader(getSupportFragmentManager());

        findViewById(R.id.ajoutplat).setOnClickListener(v1 -> {
            startActivity(new Intent(RecherchePlat.this, AjoutPlat.class));
            finish();
        });

        findViewById(R.id.confirmation).setOnClickListener(v1->
        {
            AutoCompleteTextView input = (AutoCompleteTextView)findViewById(R.id.search_meal);
            String inputString = input.getText().toString();

            try {
                this.json = ApiRecette.getJSONRecette(inputString);
                System.out.println(json);
                setContentView(R.layout.activity_afficher_plat);
                JSONArray jsonArray = new JSONArray(json.getString("results"));
                JSONObject jsonObject = new JSONObject(String.valueOf(jsonArray.get(0)));
                System.out.println(jsonObject);
                this.plat = new Plat(
                        jsonObject.getInt("id"),
                        findViewById(R.id.imageView2),
                        jsonObject.getString("title"),
                        jsonObject.getString("image"),
                        new JSONArray(new JSONObject(jsonObject.getString("nutrition")).getString("nutrients"))
                );
            } catch (Exception e) {
                e.printStackTrace();
            }

            Header.setHeader(getSupportFragmentManager());

            String textCalorie = this.plat.listNut.get(0).getName()
                    +" : "+this.plat.listNut.get(0).getAmount()
                    +" "+this.plat.listNut.get(0).getUnite();

            String textProt = this.plat.listNut.get(1).getName()
                    +" : "+this.plat.listNut.get(1).getAmount()
                    +" "+this.plat.listNut.get(1).getUnite();

            String textGras = this.plat.listNut.get(2).getName()
                    +" : "+this.plat.listNut.get(2).getAmount()
                    +" "+this.plat.listNut.get(2).getUnite();

            String textVit = this.plat.listNut.get(3).getName()
                    +" : "+this.plat.listNut.get(3).getAmount()
                    +" "+this.plat.listNut.get(3).getUnite();

            String textSucre = this.plat.listNut.get(4).getName()
                    +" : "+this.plat.listNut.get(4).getAmount()
                    +" "+this.plat.listNut.get(4).getUnite();

            ((TextView)findViewById(R.id.textView3)).setText(this.plat.nom);
            ((TextView)findViewById(R.id.Calorie)).setText(textCalorie);
            ((TextView)findViewById(R.id.protein)).setText(textProt);
            ((TextView)findViewById(R.id.gras)).setText(textGras);
            ((TextView)findViewById(R.id.VitamineC)).setText(textVit);
            ((TextView)findViewById(R.id.Sucre)).setText(textSucre);

        });

    }

}