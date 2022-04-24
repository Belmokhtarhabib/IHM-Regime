package edu.polytech.gotoslim;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiRecette{

    String baseUrl = "https://api.spoonacular.com/recipes/complexSearch";

    private static final String KEY = "6b4aa1c049db4b93b394a2277f9ca4f0";

    URL url;

    public ApiRecette() throws MalformedURLException {

    }
}
