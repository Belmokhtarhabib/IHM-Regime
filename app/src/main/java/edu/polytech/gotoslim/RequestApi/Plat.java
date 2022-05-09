package edu.polytech.gotoslim.RequestApi;

import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Plat {

    public int id;
    public String nom;
    public ArrayList<Nutriment> listNut;

    public ImageView image;

    // a la creation du plat, passer en parametre pour l'image un findViewById de l'id de l'image
    // present sur le pom d'afficher plat ( attention, l'image change )
    public Plat( int id, ImageView imageView, String nom, String imageUrl, JSONArray nutriment) throws JSONException {
        this.listNut = new ArrayList<>();
        this.id = id;
        this.nom = nom;
        this.image = imageView;
        parseNutri(nutriment);

        DrawableFromURL toDraw = new DrawableFromURL(image);
        toDraw.execute(imageUrl);
    }

    private void parseNutri(JSONArray array) throws JSONException {
        for (int i = 0; i < array.length();i++){
            JSONObject obj = new JSONObject(array.getString(i));
            this.listNut.add(new Nutriment(
                    obj.getString("name"),
                    obj.getInt("amount"),
                    obj.getString("unit")
            ));
        }
    }
}
