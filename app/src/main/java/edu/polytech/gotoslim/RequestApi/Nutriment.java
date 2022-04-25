package edu.polytech.gotoslim.RequestApi;

public class Nutriment {

    public String name;
    public double amount;
    public String unite;

    public Nutriment(String nom, double quantité, String uniter){
        this.name = nom;
        this.amount = quantité;
        this.unite = uniter;
    }
}
