package com.example.remindcalender.remindercalendar;

import android.os.Parcel;
import android.os.Parcelable;

public class Remind {
    private String activity;
    private int date, month, hour, minute,year;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int Year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Remind(String activity,int date, int month, int year, int hour, int minute) {
        this.activity = activity;
        this.date = date;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    public Remind(String activity, int hour, int minute) {
        this.activity = activity;
        this.hour = hour;
        this.minute = minute;
    }


}
