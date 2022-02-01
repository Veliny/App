package com.example.remindcalender.remindercalendar;

import android.os.Parcel;
import android.os.Parcelable;

public class Remind implements Parcelable {
    private String activity;
    private int date, month, hour, minute,year;

    protected Remind(Parcel in) {
        activity = in.readString();
        date = in.readInt();
        month = in.readInt();
        hour = in.readInt();
        minute = in.readInt();
        year = in.readInt();
    }

    public static final Creator<Remind> CREATOR = new Creator<Remind>() {
        @Override
        public Remind createFromParcel(Parcel in) {
            return new Remind(in);
        }

        @Override
        public Remind[] newArray(int size) {
            return new Remind[size];
        }
    };

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

    public Remind(int date, int month, int year, int hour, int minute) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(activity);
        dest.writeInt(date);
        dest.writeInt(month);
        dest.writeInt(hour);
        dest.writeInt(minute);
        dest.writeInt(year);
    }
}
