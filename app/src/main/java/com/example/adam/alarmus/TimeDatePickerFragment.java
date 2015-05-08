package com.example.adam.alarmus;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TabHost;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Adam on 7.5.2015.
 */
public class TimeDatePickerFragment extends DialogFragment {

    private TabHost tabs;
    private DatePicker mDatePicker;
    private TimePicker mTimePicker;
    private onSetaDateListener callback;
    private Calendar calendar;

    public interface onSetaDateListener{
            public void GetDateFrom(Calendar calendar);
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setTitle("Date and Time");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
              int hour =  mTimePicker.getCurrentHour();
              int min =  mTimePicker.getCurrentMinute();

              int day = mDatePicker.getDayOfMonth();
              int month = mDatePicker.getMonth();
              int year = mDatePicker.getYear();

              calendar = Calendar.getInstance();
              calendar.set(year,month,day,hour,min, 00);
              callback.GetDateFrom(calendar);

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });

        AlertDialog dialog = builder.create();
        dialog.setView(initView(inflater));
        return  dialog;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (onSetaDateListener)activity;
        }catch (ClassCastException  e){

        }

    }

    private View initView(LayoutInflater inflater){

        View view = inflater.inflate(R.layout.date_dialog, null);
        tabs=(TabHost) view.findViewById(R.id.tabHost);
        tabs.setup();

        TabHost.TabSpec tabpage1 = tabs.newTabSpec("Date");
        tabpage1.setContent(R.id.shareIndividual);
        tabpage1.setIndicator("Date");
        tabs.addTab(tabpage1);

        TabHost.TabSpec tabpage2 = tabs.newTabSpec("two");
        tabpage2.setContent(R.id.shareGroup);
        tabpage2.setIndicator("Time");
        tabs.addTab(tabpage2);

        mDatePicker = (DatePicker) view.findViewById(R.id.date_picker);
        mTimePicker = (TimePicker) view.findViewById(R.id.time_picker);
        Calendar c = Calendar.getInstance();
        mTimePicker.setIs24HourView(true);
        mTimePicker.setCurrentHour(c.get(Calendar.HOUR_OF_DAY));
        mTimePicker.setCurrentMinute(c.get(Calendar.MINUTE));
        return view;
    }

}
