package edu.polytech.gotoslim.statetpoid;

public class Controller_StatEtPoids{

    private View_StatEtPoids view;
    private final Model_StatEtPoids model;

    public Controller_StatEtPoids(){
        this.model = new Model_StatEtPoids();
    }

    public void setView(View_StatEtPoids view) {
        this.view = view;
    }

    public void miseAJourInView(){

        int taille = Integer.parseInt(view.inputTaille.getText().toString());
        int poids = Integer.parseInt(view.inputPoids.getText().toString());
        System.out.println("taille value : "+taille);
        System.out.println("poids value : "+poids);
        model.miseAJour_Stat(taille,poids);
        view.MAJ(this.model);
    }


}
