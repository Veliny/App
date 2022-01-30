package com.example.remindcalender.remindercalendar;

public class Remind {
    private String activity;
    private int date, month, hour, minute;

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

    public Remind(int date, int month, int hour, int minute) {
        this.date = date;
        this.month = month;
        this.hour = hour;
        this.minute = minute;
    }
}
