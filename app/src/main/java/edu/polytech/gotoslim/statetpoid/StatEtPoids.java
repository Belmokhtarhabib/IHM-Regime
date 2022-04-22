package edu.polytech.gotoslim.statetpoid;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.ParametresActivity;
import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.ajoutplat.AjoutPlat;

public class StatEtPoids extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_stat_et_poids);

        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(StatEtPoids.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> startActivity(new Intent(StatEtPoids.this, MainActivity.class)));

        Controller_StatEtPoids controller = new Controller_StatEtPoids();

        Model_StatEtPoids model = new Model_StatEtPoids(controller);
        View_StatEtPoids vue = new View_StatEtPoids(controller,model,(ConstraintLayout) findViewById(R.id.stat_poids));
        controller.setView(vue);

        model.addObserver(vue);

        vue.getBouttonMAJ().setOnClickListener(click -> controller.miseAJourInView());

        System.out.println("LANCEMENT REUSSI");



    }
}