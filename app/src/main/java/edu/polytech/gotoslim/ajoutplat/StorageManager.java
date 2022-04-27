package edu.polytech.gotoslim.ajoutplat;

import android.content.Context;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StorageManager {

    public static void saveBitmapToStorage(Context context, Bitmap bitmapImage, File file){
        FileOutputStream fileStream = null;
        try {
            fileStream = new FileOutputStream(file);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 80, fileStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fileStream!=null) {
                try {
                    fileStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

