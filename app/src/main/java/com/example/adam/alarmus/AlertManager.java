package com.example.adam.alarmus;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Adam on 8.5.2015.
 */
public class AlertManager {

    public static void setAlarm(Context context, Calendar calendar){

        Toast.makeText(context, "Alarm has been set.", Toast.LENGTH_LONG).show();
        long timer = calendar.getTimeInMillis();

        Intent myIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, myIntent,PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (android.app.AlarmManager)context.getSystemService(context.ALARM_SERVICE);

        alarmManager.set(android.app.AlarmManager.RTC_WAKEUP, timer, pendingIntent);
    }

}
