package com.example.staffshifter;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class ReminderReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String message = intent.getStringExtra("message");

        NotificationManager nm =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        String channelId = "staff_reminder";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel =
                    new NotificationChannel(
                            channelId,
                            "Staff Reminder",
                            NotificationManager.IMPORTANCE_HIGH
                    );
            nm.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, channelId)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Lecture Adjustment Reminder")
                        .setContentText(message)
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_HIGH);

        nm.notify(1, builder.build());
    }
}
