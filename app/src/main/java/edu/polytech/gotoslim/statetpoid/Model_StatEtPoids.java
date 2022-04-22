package edu.polytech.gotoslim.statetpoid;

import android.graphics.ColorSpace;

import java.util.Observable;

public class Model_StatEtPoids extends Observable {
    private static final int POIDS_ORIGINE = 90;
    private Controller_StatEtPoids controle;

    private int taille;
    private int poids;
    private int imc;
    private int poidPerdu;

    public Model_StatEtPoids(Controller_StatEtPoids controller_statEtPoids){
        super();
        this.controle = controller_statEtPoids;
        this.taille = 186;
        this.poids = 90;
        this.imc = Imc(taille,poids);
        this.poidPerdu = 0;
    }

    public int getTaille(){
        return this.taille;
    }

    public int getPoids() {
        return this.poids;
    }

    public double getImc() {
        return this.imc;
    }

    public int getPoidPerdu() {
        return this.poidPerdu;
    }

    public void miseAJour_Stat(int taille,int poids){
        this.taille = taille;
        this.poids = poids;
        this.imc = Imc(taille,poids);
        this.poidPerdu = Math.abs(poids - POIDS_ORIGINE);
        System.out.println("ON EST DANS LE MODEL, mise a jour faite");
        this.setChanged();
        this.notifyObservers();
        // pouvoir notifier aussi le graph plus tard
    }

    public int Imc(int taille,int poids){
        double tailleMetre = taille*0.01;
        double imc = poids / (tailleMetre*tailleMetre);
        return (int)imc;
    }
}
