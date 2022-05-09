package edu.polytech.gotoslim.RequestApi;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class ApiRecette{

    private static final String apiReqGet = "https://api.spoonacular.com/recipes/complexSearch?apiKey=6933414d51f54eb0bfbe27e4eca082d7&query=";
    private static final String suiteReq = "&maxVitaminC=100&maxProtein=100&maxCalories=800&maxFat=25&maxSugar=100&number=1";

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
        try (InputStream urlInput = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(urlInput));
            String json_txt = readAll(rd);
            return new JSONObject((json_txt));
        }
    }
}
