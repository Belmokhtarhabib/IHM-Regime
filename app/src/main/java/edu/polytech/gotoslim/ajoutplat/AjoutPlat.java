package edu.polytech.gotoslim.ajoutplat;

import static edu.polytech.gotoslim.NotificationChannelGTS.CHANNEL_ID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import edu.polytech.gotoslim.MainActivity;
import edu.polytech.gotoslim.ParametresActivity;
import edu.polytech.gotoslim.R;

public class AjoutPlat extends AppCompatActivity {

    private int notificationId = 0;
    private static final float TRANSPARENT = 0.3f;
    private static final float OPAQUE = 1;
    private Bitmap picture = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_ajout_plat);

        findViewById(R.id.settings).setOnClickListener(v1-> startActivity(new Intent(AjoutPlat.this, ParametresActivity.class)));
        findViewById(R.id.home).setOnClickListener(v1-> startActivity(new Intent(AjoutPlat.this, MainActivity.class)));

        EditText editTextNomPlat = findViewById(R.id.ajout_nom_plat);

        findViewById(R.id.ajout_envoyer).setAlpha(TRANSPARENT);

        findViewById(R.id.ajout_envoyer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomPlat = ((EditText) findViewById(R.id.ajout_nom_plat)).getText().toString();
                System.out.println(nomPlat);
                if (picture != null && !TextUtils.isEmpty(nomPlat)){
                    sendNotificationOnChannel(nomPlat,CHANNEL_ID, NotificationCompat.PRIORITY_HIGH);
                }
            }
        });

        findViewById(R.id.button_image).setOnClickListener( click -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);   // Create an implicit intent, for image capture
            startActivityForResult(intent, PermissionFactory.REQUEST_ID_IMAGE_CAPTURE);      // Start camera and wait for the results.
        });

        editTextNomPlat.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                findViewById(R.id.ajout_envoyer).setAlpha(picture != null && !TextUtils.isEmpty(((EditText) findViewById(R.id.ajout_nom_plat)).getText().toString()) ? OPAQUE : TRANSPARENT);
            }
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
                    if (picture != null && !TextUtils.isEmpty(((EditText) findViewById(R.id.ajout_nom_plat)).getText().toString())){
                        findViewById(R.id.ajout_envoyer).setAlpha(OPAQUE);
                    }
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