package com.company.week2.day1;

import java.time.LocalDate;

public class Module9 {

    public static void scheduling(){

        LocalDate lastRunDate = LocalDate.of(2016, 11, 11);
        LocalDate today = LocalDate.of(2016, 11, 20);

        int daysPassed = today.getDayOfYear() - lastRunDate.getDayOfYear();
        if(daysPassed < 0){
            daysPassed = daysPassed + 365;
        }

        System.out.println();
        if (today.isBefore(lastRunDate.plusDays(7))){
            System.out.println("Not time yet, ".concat(daysPassed + " days since last run"));
        }else{
            System.out.println(daysPassed + " days since last run, ".concat("time to run again!"));
        }
    }
}
