package edu.polytech.gotoslim.statetpoid;

import android.graphics.ColorSpace;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import edu.polytech.gotoslim.R;

public class Controller_StatEtPoids{

    private View_StatEtPoids view;
    private Model_StatEtPoids model;

    public Controller_StatEtPoids(){
        this.model = new Model_StatEtPoids(this);
    }

    public void setView(View_StatEtPoids view) {
        this.view = view;
    }

    public void miseAJourInView(){
        //int taille = Integer.parseInt(((EditText)groupeVu.findViewById(R.id.input_taille)).getText().toString());
        //int poids = Integer.parseInt(((EditText)groupeVu.findViewById(R.id.input_poids)).getText().toString());

        int taille = Integer.parseInt(view.inputTaille.getText().toString());
        int poids = Integer.parseInt(view.inputPoids.getText().toString());
        System.out.println("taille value : "+taille);
        System.out.println("poids value : "+poids);
        model.miseAJour_Stat(taille,poids);
        view.majText(this.model);
    }


}
