package edu.polytech.gotoslim.conseil.listCreation.basedonne;

import com.google.firebase.database.FirebaseDatabase;

public class DataBase {

    private static final FirebaseDatabase firebase = FirebaseDatabase.getInstance("https://ihm-gotoslim-default-rtdb.europe-west1.firebasedatabase.app/");


    public DataBase(){}

    public static FirebaseDatabase getInstance(){
        return firebase;
    }
}
