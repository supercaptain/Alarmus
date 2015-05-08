package com.example.adam.alarmus;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class AlarmActivity extends ActionBarActivity {

    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        vibrator = (Vibrator) this.getSystemService(this.VIBRATOR_SERVICE);
        long vibrated[] = {100, 200,500,200,1100,2000,100,300};
        vibrator.vibrate(vibrated, 0);

        findViewById(R.id.EndButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.cancel();
                stopService(new Intent(getApplicationContext(), AlarmService.class));
                /*sssssssssssssssss*/
            }
        });
    }

    @Override
    protected  void onPause(){
        super.onPause();
            vibrator.cancel();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alarm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
