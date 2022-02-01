package com.example.remindcalender.remindercalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class input extends AppCompatActivity {
    TimePickerDialog picker;
    EditText text;
    EditText text1;
    int h = 0;
    int m = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Intent intent = getIntent();

        ArrayList<Remind> rem = new ArrayList<>();
//        rem = arrayClass.getTimeSet();

        int date = intent.getIntExtra("day", 1);
        int month = intent.getIntExtra("month", 1);
        int year = intent.getIntExtra("year",1);

        String day = date + "-" + month + "-" + year;
        TextView dayText = findViewById(R.id.selectedDay);
        dayText.setText(day);


        Button save = findViewById(R.id.savebtn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text == null){
                    Toast.makeText(input.this, "Set your reminder!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(input.this, MainActivity.class);
                    rem.add(new Remind(date, month, year, h, m));
                    intent.putParcelableArrayListExtra("time", rem);
//                    Remind rem = new Remind(date, month, year, h, m);
                    Toast.makeText(input.this, "Reminder added", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

        //buat masukin jam ke edit text
        text = findViewById(R.id.times);
        text.setInputType(InputType.TYPE_NULL);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                picker = new TimePickerDialog(input.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                h = sHour;
                                m = sMinute;
                                text.setText(sHour + ":" + sMinute);


                            }
                        }, hour, minutes, true);
                picker.show();

            }
        });


    }

}