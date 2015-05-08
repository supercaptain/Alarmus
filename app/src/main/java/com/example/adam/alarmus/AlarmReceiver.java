package com.example.adam.alarmus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Budik spusten", "  Spusteno ");
        Toast.makeText(context, "  Spusteno ", Toast.LENGTH_LONG).show();
        Intent p = new Intent(context, AlarmActivity.class);
        p.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(p);
    }
}
