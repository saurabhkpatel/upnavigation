package com.saurabhpatel.upnavigationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    final Button showNotification = (Button) findViewById(R.id.showNotificationButton);

    showNotification.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(final View v) {
        showNotification();
      }
    });
  }

  private void showNotification() {

    // Instantiate a Builder object.
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
    // Creates an Intent for the Activity
    Intent notifyIntent = new Intent(this, SubActivity.class);

    // Creates the PendingIntent
    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

    // Puts the PendingIntent into the notification builder
    builder.setContentIntent(pendingIntent);
    builder.setContentText("Testing Up button, click here to open SubActivity.");
    builder.setContentText("Up Navigation Demo");
    builder.setSmallIcon(R.mipmap.ic_launcher);
    // Notifications are issued by sending them to the
    // NotificationManager system service.
    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    // Builds an anonymous Notification object from the builder, and
    // passes it to the NotificationManager
    mNotificationManager.notify(10, builder.build());

  }
}
