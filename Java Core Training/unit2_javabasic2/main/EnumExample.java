package com.demo.unit2_javabasic2.main;

import java.util.Calendar;
import java.util.Locale;

public class EnumExample {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("Today is: " + valueOf(calendar));
    }

    public enum EVnDay {
        THU_HAI,
        THU_BA,
        THU_BAY,
        CHU_NHAT,
        KHONG_BIET
    }

    public static EVnDay valueOf(Calendar calendar) {

        String type = calendar.getDisplayName(
                Calendar.DAY_OF_WEEK,
                Calendar.SHORT,
                new Locale("vi")
        );

        System.out.println(type);

        return switch (type) {
            case "Th 2" -> EVnDay.THU_HAI;
            case "Th 3" -> EVnDay.THU_BA;
            case "Th 7" -> EVnDay.THU_BAY;
            case "CN" -> EVnDay.CHU_NHAT;
            default -> EVnDay.KHONG_BIET;
        };
    }
}
