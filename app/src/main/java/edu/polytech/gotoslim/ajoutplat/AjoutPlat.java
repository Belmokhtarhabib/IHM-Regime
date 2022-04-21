package edu.polytech.gotoslim.ajoutplat;

import static edu.polytech.gotoslim.NotificationChannelGTS.CHANNEL_ID;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import edu.polytech.gotoslim.Header;
import edu.polytech.gotoslim.R;

public class AjoutPlat extends Header {

    private int notificationId = 0;
    private Bitmap picture = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ViewGroup vg = (ViewGroup) findViewById(R.id.lldata);
        ViewGroup.inflate(AjoutPlat.this, R.layout.activity_ajout_plat, vg);

        findViewById(R.id.ajout_envoyer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomPlat = ((EditText) findViewById(R.id.ajout_nom_plat)).getText().toString();
                sendNotificationOnChannel(nomPlat,CHANNEL_ID, NotificationCompat.PRIORITY_HIGH);
            }
        });

        findViewById(R.id.button_image).setOnClickListener( click -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);   // Create an implicit intent, for image capture
            startActivityForResult(intent, PermissionFactory.REQUEST_ID_IMAGE_CAPTURE);      // Start camera and wait for the results.
        });
    }

    private void sendNotificationOnChannel(String nomPlat, String channelId, int priority) {

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(),channelId)
                .setSmallIcon(R.drawable.plus_circle)
                .setContentTitle("Demande envoyée !")
                .setContentText("Votre " + nomPlat.toLowerCase() + " nous a bien été envoyée !")
                .setPriority(priority)
                .setLargeIcon(picture)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(picture).bigLargeIcon(null));

        NotificationManagerCompat.from(this).notify(++notificationId,notification.build());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PermissionFactory.REQUEST_ID_IMAGE_CAPTURE) {
            switch (resultCode) {
                case RESULT_OK:
                    picture = (Bitmap) data.getExtras().get("data");
                    ((ImageView) findViewById(R.id.imageView)).setImageBitmap(picture);
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(getApplicationContext(), "Action canceled", Toast.LENGTH_LONG).show();
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "camera result: Action Failed", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}