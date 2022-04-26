package edu.polytech.gotoslim.RequestApi;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ApiRecette{

    private final String TAG = "ApiRecette";
    private static final String apiReqGet
            = "https://api.spoonacular.com/recipes/complexSearch?apiKey=6933414d51f54eb0bfbe27e4eca082d7&query=";
    private static final String suiteReq = "&maxVitaminC=100&maxProtein=100&maxCalories=800&maxFat=25&maxSugar=100&number=1";

    private static final String KEY = "6b4aa1c049db4b93b394a2277f9ca4f0";

    private String urlReq;


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while((cp = rd.read()) != -1){
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject getJSONRecette(String query) throws Exception{
        String url = apiReqGet + query + suiteReq;
        System.out.println(url);
        InputStream urlInput = new URL(url).openStream();
        try{
            BufferedReader rd = new BufferedReader(new InputStreamReader(urlInput));
            String json_txt = readAll(rd);
            JSONObject json = new JSONObject((json_txt));
            return json;
        }
        finally {
            urlInput.close();
        }
    }

    public String getUrlReq() {
        return urlReq;
    }
    public void setUrlReq( String query){
        this.urlReq = apiReqGet + query + suiteReq;
    }
}
