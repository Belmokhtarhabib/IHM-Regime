package edu.polytech.gotoslim.statetpoid;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import edu.polytech.gotoslim.Header;
import edu.polytech.gotoslim.R;

public class StatEtPoids extends Header {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ViewGroup vg = (ViewGroup) findViewById(R.id.lldata);
        ViewGroup.inflate(StatEtPoids.this, R.layout.activity_stat_et_poids, vg);

        Controller_StatEtPoids controller = new Controller_StatEtPoids();

        Model_StatEtPoids model = new Model_StatEtPoids(controller);
        View_StatEtPoids vue = new View_StatEtPoids(controller,model,(ConstraintLayout) findViewById(R.id.stat_poids));
        controller.setView(vue);

        model.addObserver(vue);

        vue.getBouttonMAJ().setOnClickListener(click -> controller.miseAJourInView());

        System.out.println("LANCEMENT REUSSI");
    }
}