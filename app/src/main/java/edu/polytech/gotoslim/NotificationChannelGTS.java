package edu.polytech.gotoslim;


import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import java.util.Objects;

public class NotificationChannelGTS extends Application {

    public static final String CHANNEL_ID = "Channel ID";

    private static NotificationManager notificationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            android.app.NotificationChannel channel = new android.app.NotificationChannel(CHANNEL_ID,"Notification channel name",NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Notification channel description");
            notificationManager = getSystemService(NotificationManager.class);
            Objects.requireNonNull(notificationManager).createNotificationChannel(channel);
        }
    }
}
