package edu.polytech.gotoslim.conseil.boisson;

import static edu.polytech.gotoslim.conseil.boisson.ApplicationBoisson.BOISSON;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.gotoslim.R;

public class BoissonListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boisson);
        ListBoisson boissons = new ListBoisson();

        //Création et initialisation de l'Adapter pour les diplomes

        BoissonAdapter adapter = new BoissonAdapter(getApplicationContext(), boissons);

        //Récupération du composant ListView

        ListView list = findViewById(R.id.listViewBoisson);

        //Initialisation de la liste avec les données

        list.setAdapter(adapter);
    }

    //@Override
    public void onClickBoisson(Boisson item){
        Intent intent = new Intent(getApplicationContext(), BoissonActivity.class);
        intent.putExtra(BOISSON, (Parcelable) item);
        startActivity(intent);


    }
}
