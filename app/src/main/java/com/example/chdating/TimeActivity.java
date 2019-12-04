package com.example.chdating;

import android.app.Activity;
import java.util.Calendar;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimeActivity extends Activity {
    private TextView textView;
    private TimePicker timePicker;
    private DatePicker datePicker;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time);
        Calendar calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        hour=calendar.get(Calendar.HOUR);
        minute=calendar.get(Calendar.MINUTE);
        datePicker=findViewById(R.id.datepicker);
        timePicker=findViewById(R.id.timepicker);
        textView=findViewById(R.id.timeview);
        textView.setText(new StringBuilder().append(year).append("/").append(format(month+1)).append("/").append(format(day)).append(" ").append(format(hour)).append(":").append(format(minute)));

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                TimeActivity.this.year=year;
                TimeActivity.this.month=month;
                TimeActivity.this.day=day;
                textView.setText(new StringBuilder().append(year).append("/").append(format(month+1)).append("/").append(format(day)).append(" ").append(format(hour)).append(":").append(format(minute)));
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                TimeActivity.this.hour=hour;
                TimeActivity.this.minute=minute;
                textView.setText(new StringBuilder().append(year).append("/").append(format(month+1)).append("/").append(format(day)).append(" ").append(format(hour)).append(":").append(format(minute)));
            }
        });
    }

    private String format(int time){
        String str=""+time;
        if(str.length()==1)
            str="0"+str;
        return str;
    }

}
