package com.example.remindcalender.remindercalendar;

import android.util.Log;

import java.util.ArrayList;

public class arrayClass {
    private static ArrayList<Remind> timeset = new ArrayList<>();

    public static void addTime(Remind remind){
        timeset.add(remind);
    }

    public static void deleteTime(Integer index){
        timeset.remove(index);
    }

    public static ArrayList<Remind> getTimeSet()
    {
        return timeset;
    }

    public boolean isEmpty() {
        return timeset.isEmpty();
    }

    public boolean isEventExist(int year, int month, int datOfMonth) {
        if (timeset.isEmpty())
            return false;

        Log.e("isEventExist", "" + year + " " + month + " " + datOfMonth);

        for (int i = 0; i < timeset.toArray().length; i++) {
            Log.e("isEventExistInsideLoop", "" + timeset.get(i).getYear() + " " + timeset.get(i).getMonth() + " " + timeset.get(i).getDate());
            if (timeset.get(i).getMonth() == month &&
                timeset.get(i).getYear() == year &&
                timeset.get(i).getDate() == datOfMonth) {
                Log.e("isEventExist", "Yes");
                return true;
            }
        }
        return false;
    }

    public static Remind getTimeData(int year, int month, int datOfMonth) {
        int position = 0;
        for (int i = 0; i < timeset.toArray().length; i++) {
            if (timeset.get(i).getMonth() == month &&
                    timeset.get(i).getYear() == year &&
                    timeset.get(i).getDate() == datOfMonth) {
                position = i;
            }
        }

        return new Remind(timeset.get(position).getActivity(), timeset.get(position).getHour(), timeset.get(position).getMinute());
    }

}
