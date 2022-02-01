package com.example.remindcalender.remindercalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private int currentDays;
    private int currentMonths;
    private int currentYears;
    private int Daysindex;
    private int Monthsindex;
    private int Yearsindex;
    arrayClass arr = new arrayClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendarView = findViewById(R.id.calendarview);
        TextView text = findViewById(R.id.tampilkan);
        Button addActivity = findViewById(R.id.buttonadd);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Log.e("OnSelectedDayChange", "User moved");

                if (arr.isEmpty()) {
                    Log.e("Main", "Array Empty");
                    text.setText("");
                } else if (arr.isEventExist(year, month + 1, dayOfMonth)) {
                    Log.e("Main", "Event Exist");
                    Remind data = arr.getTimeData(year, month + 1, dayOfMonth);

                    text.setText("Event : " + data.getActivity() + " Time : " + data.getHour() + ":" + data.getMinute());
                } else {
                    Log.e("Main", "Event doesnt exist");
                }


                addActivity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this , input.class);
                        intent.putExtra("day", dayOfMonth );
                        intent.putExtra("month", month+1);
                        intent.putExtra("year", year);
                        startActivity(intent);
                    }
                });
            }
        });

        Intent intent = this.getIntent();


//        if(!rem.isEmpty()) {
////        Remind rem = getIntent().getParcelableExtra("time");
//
//        String show = "Date : " + rem.get(0);
////                +"\nMonth : " + rem.getMonth()
////                +"\nYear : " + rem.getYear()
////                +"\nTime: " + rem.getHour() + ":" + rem.getMinute();
//        text.setText(show);
//        }
    }
}