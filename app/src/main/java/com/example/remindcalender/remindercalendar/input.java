package com.example.remindcalender.remindercalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class input extends AppCompatActivity {
    TimePickerDialog picker;
    EditText text;
    EditText text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Intent intent = getIntent();

        ArrayList<Remind> timeSet = new ArrayList<>();
        timeSet = arrayClass.getTimeSet();
        int date = intent.getIntExtra("day", 0);
        int month = intent.getIntExtra("month", 0);

        Button save = findViewById(R.id.savebtn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayClass.getTimeSet().isEmpty()){
                    Toast.makeText(input.this, "Set your reminder!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(input.this, output.class);
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
                                text.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                picker.show();
                //lempar ke array kali?
                Remind object = new Remind(date, month, hour, minutes);
                arrayClass.getTimeSet().add(object);
                Toast.makeText(input.this, "Reminder added", Toast.LENGTH_SHORT).show();
            }
        });

    }
}