package com.demo.unit2_javabasic2.main;

import java.util.Calendar;
import java.util.Locale;

public class StringSwitchExample {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 5);

        System.out.println("Type of day: " + getTypeOfDay(calendar));
    }

    public static String getTypeOfDay(Calendar calendar) {

        String type = calendar.getDisplayName(
                Calendar.DAY_OF_WEEK,
                Calendar.SHORT,
                new Locale("vi"));

        System.out.println(type);

        switch (type) {
            case "Th 2":
                return "Start of date";
            case "Th 3":
            case "Th 4":
            case "Th 5":
            case "Th 6":
                return "Midweek";
            case "Th 7":
                return "End of work week";
            case "CN":
                return "Weekend";
        }

        return "Unknown";
    }
}
