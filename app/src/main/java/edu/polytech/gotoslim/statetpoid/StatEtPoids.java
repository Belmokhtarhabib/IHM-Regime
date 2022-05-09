package edu.polytech.gotoslim.statetpoid;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import edu.polytech.gotoslim.Header;
import edu.polytech.gotoslim.R;

public class StatEtPoids extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_stat_et_poids);

        Header.setHeader(getSupportFragmentManager());

        Controller_StatEtPoids controller = new Controller_StatEtPoids();

        Model_StatEtPoids model = new Model_StatEtPoids();
        View_StatEtPoids vue = new View_StatEtPoids(controller,model,findViewById(R.id.stat_poids));
        controller.setView(vue);

        model.addObserver(vue);

        vue.getBouttonMAJ().setOnClickListener(click -> controller.miseAJourInView());

        System.out.println("LANCEMENT REUSSI");
    }
}