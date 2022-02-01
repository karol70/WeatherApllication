package com.karol.models;

import java.time.LocalDate;

public class DateManager {
    public String getDateInyyyymmddFormat(String date) {
        String dateInRightFormat = date.replace("-", "");
        dateInRightFormat = dateInRightFormat.substring(0, 8);
        return dateInRightFormat;
    }

    public String getWeekDayName(String date) {
        date = date.replace("-", "");
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));

        LocalDate localDate = LocalDate.of(year,month,day);
        java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.toString();
    }
}
