package edu.polytech.gotoslim.conseil.plat;

import static edu.polytech.gotoslim.conseil.plat.ApplicationPlat.PLAT;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.R;

public class PlatListActivity extends AppCompatActivity implements Ilistener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plat);
        ListPlat plats = new ListPlat();

        //Création et initialisation de l'Adapter pour les diplomes

        PlatAdapter adapter = new PlatAdapter(getApplicationContext(), plats);

        //Récupération du composant ListView

        ListView list = findViewById(R.id.listViewPlat);

        //Initialisation de la liste avec les données

        list.setAdapter(adapter);
        adapter.addListener(this);
    }

    @Override
    public void onClickPlat(Plat item){
        Intent intent = new Intent(getApplicationContext(), PlatActivity.class);
        intent.putExtra(PLAT, (Parcelable) item);
        startActivity(intent);


    }
}
