package edu.polytech.gotoslim.RequestApi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DrawableFromURL extends AsyncTask<String, Void, Bitmap> {
    ImageView imageView;

    public DrawableFromURL(ImageView imageView){
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String url = strings[0];
        Bitmap image = null;
        try{
            InputStream inputStream = new URL(url).openStream();
            image = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    protected void onPostExecute(Bitmap image){
        imageView.setImageBitmap(image);
    }
}
