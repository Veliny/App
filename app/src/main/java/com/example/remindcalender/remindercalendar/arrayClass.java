package com.example.remindcalender.remindercalendar;

import java.util.ArrayList;

public class arrayClass {
    public static ArrayList<Remind> timeset = new ArrayList<Remind>();

    public static void deleteTime(Integer index){
        timeset.remove(index);
    }

    public static ArrayList<Remind> getTimeSet()
    {
        return timeset;
    }
}
