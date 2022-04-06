package edu.polytech.gotoslim.conseil.boisson;

import java.util.ArrayList;

import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.conseil.boisson.Boisson;


public class ListBoisson extends ArrayList<Boisson>{


    public ListBoisson(){
        add(new Boisson("Jus de bétrave", R.drawable.jusbetrave));

    }
}