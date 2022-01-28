package com.example.remindcalender.remindercalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private int currentDays;
    private int currentMonths;
    private int currentYears;
    private int Daysindex;
    private int Monthsindex;
    private int Yearsindex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendarView = findViewById(R.id.calendarview);

        List<String> calendarlist =  new ArrayList<>();
        int[] days = new int[31];
        int[] months = new int[12];
        int[] years = new int[10];

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                currentYears = year;
                currentMonths = month;
                currentDays = dayOfMonth;

                for (int i = 0; i< 31; i++){
                    if (days[i] == currentDays){
                        for (int j= 0; j<12; j++){
                            if(months[j] == currentMonths){

                                return;
                            }
                        }
                    }
                }

            }
        });


    }
}