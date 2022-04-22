package edu.polytech.gotoslim.ajoutplat;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionFactory {

    public static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    public static final int PERMISSIONS_REQUEST_READ_MEDIA = 1000;

    public static boolean buildAndCheck(Activity callbackActivity, String permission, String arg){
        int permissionCheck = ContextCompat.checkSelfPermission(callbackActivity, permission);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(callbackActivity, new String[]{permission,arg}, PERMISSIONS_REQUEST_READ_MEDIA);
            return false;
        }
        return true ;
    }
}
