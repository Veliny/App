package com.example.remindcalender.remindercalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendarView = findViewById(R.id.calendarview);
        TextView text = findViewById(R.id.tampilkan);

        List<String> calendarlist =  new ArrayList<>();
        int[] days = new int[31];
        int[] months = new int[12];
        int[] years = new int[10];
        Button addActivity = findViewById(R.id.buttonadd);

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
                                //print disini
//                                text.setText();
                                return;
                            }
                        }
                    }
                }

            }
        });

        addActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        Intent intent = new Intent(MainActivity.this , input.class);
                        intent.putExtra("day", dayOfMonth );
                        intent.putExtra("month", month);
                        intent.putExtra("year", year);
                        startActivity(intent);
                    }
                });
            }
        });


    }
}