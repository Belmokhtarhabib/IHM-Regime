package edu.polytech.gotoslim.RequestApi;

import android.widget.ImageView;

public class Plat {

    public int id;
    public String nom;
    public Nutriment nutriment;

    private DrawableFromURL toDraw;
    public ImageView image;

    // a la creation du plat, passer en parametre pour l'image un findViewById de l'id de l'image
    // present sur le pom d'afficher plat ( attention, l'image change )
    public Plat( int id, ImageView imageView, String nom, String imageUrl, Nutriment nutriment){
        this.id = id;
        this.nom = nom;
        this.nutriment = nutriment;
        this.image = imageView;

        toDraw = new DrawableFromURL(image);
        toDraw.execute(imageUrl);
    }
}
