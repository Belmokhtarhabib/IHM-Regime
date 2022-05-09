package edu.polytech.gotoslim.statetpoid;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import edu.polytech.gotoslim.R;

public class View_StatEtPoids implements Observer {
    Controller_StatEtPoids controller;
    // public donc on peut recup la valeur direct pour informer le controleur
    public TextView textTaille;
    public TextView textPoids;
    public TextView textIMC;
    public TextView textPoidsPerdu;

    public EditText inputPoids;
    public EditText inputTaille;

    private final Button bouttonMAJ;

    public View_StatEtPoids(Controller_StatEtPoids controller,Model_StatEtPoids model, ViewGroup app){
        this.controller=controller;
        textTaille = (TextView) app.findViewById(R.id.taille);
        textPoids = (TextView) app.findViewById(R.id.poids);
        textIMC = (TextView) app.findViewById(R.id.imc);
        textPoidsPerdu = (TextView) app.findViewById(R.id.poidsPerdu);
        //( pour faire un settext pour changer le text de ces donner)

        inputPoids = (EditText) app.findViewById(R.id.input_poids);
        inputTaille = (EditText) app.findViewById(R.id.input_taille);

        bouttonMAJ = (Button) app.findViewById(R.id.button_setStat);

        majText(model);
    }
    @Override
    public void update(Observable observable, Object o) {
        System.out.println("MESSAGE DEPUIS L'UPDATE");
        Model_StatEtPoids m = (Model_StatEtPoids) observable;

        majText(m);
    }

    /**
     * alternative a l'update ne marchant pas
     */
    public void MAJ(Model_StatEtPoids model){
        System.out.println("MESSAGE DEPUIS L'UPDATE");
        majText(model);
    }

    public void majText(Model_StatEtPoids model){
        String motTaille = "Taille actuel : "+model.getTaille();
        String motPoids = "Poids actuel : "+model.getPoids();
        String motImc = "Votre IMC est de : "+model.getImc();
        String motPerdu = "Poids perdu depuis le debut de votre regime : "+model.getPoidPerdu();

        this.textTaille.setText(motTaille);
        this.textPoids.setText(motPoids);
        this.textIMC.setText(motImc);
        this.textPoidsPerdu.setText(motPerdu);
    }

    public Button getBouttonMAJ() {
        return bouttonMAJ;
    }
}
