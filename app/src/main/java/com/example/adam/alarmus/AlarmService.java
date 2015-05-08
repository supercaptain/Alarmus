package com.example.adam.alarmus;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmService extends Service {
    public AlarmService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 1);
        Toast.makeText(this, "Cal " + calendar.toString(), Toast.LENGTH_LONG).show();
        //convert time to ms
        long timer = calendar.getTimeInMillis();

        Intent myIntent = new Intent(this, AlarmReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent,PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarmManager = (AlarmManager)this.getSystemService(this.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, timer, pendingIntent);

        return 0;
    }




}
