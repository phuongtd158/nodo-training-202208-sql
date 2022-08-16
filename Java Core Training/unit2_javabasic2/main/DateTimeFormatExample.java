package com.demo.unit2_javabasic2.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateTimeFormatExample {
    public static void main(String[] args) {
        Locale locale = new Locale("vi", "VN");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE, dd MMMMM yyyy", locale);
        Calendar calendar = Calendar.getInstance();

        System.out.println(dateFormat.format(calendar.getTime()));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    }
}
