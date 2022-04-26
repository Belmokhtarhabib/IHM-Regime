package edu.polytech.gotoslim.RequestApi;

import android.os.AsyncTask;

import org.json.JSONObject;

import edu.polytech.gotoslim.recherchePlat.AfficherPlatActivity;

public class RequestThread extends AsyncTask<String, Void, JSONObject> {

    AfficherPlatActivity activity;

    public RequestThread(AfficherPlatActivity activity){
        this.activity = activity;
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        JSONObject response = null;
        try{
            response = ApiRecette.getJSONRecette(strings[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject){
        activity.setItemRecup(jsonObject);
        System.out.println(jsonObject.toString());
    }
}
