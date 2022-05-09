package edu.polytech.gotoslim.RequestApi;

public class Nutriment {

    public String name;
    public double amount;
    public String unite;

    public Nutriment(String nom, double quantity, String unite){
        this.name = nom;
        this.amount = quantity;
        this.unite = unite;
    }

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getUnite() {
        return unite;
    }
}
