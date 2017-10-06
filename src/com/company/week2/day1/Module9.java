package com.company.week2.day1;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Module9 {

    public static void scheduling(){

        LocalDate lastRunDate = LocalDate.of(2016, 11, 11),
                  today = LocalDate.of(2016, 11, 20);

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

    static String[] multipleUnits(int year, int month, int day){ // finds out whether they are plural or not
        int [] indicators = {year, month, day};
        String [] y = {"year", "month", "day"};
        for(int i = 0; i < y.length; i++){
            if (indicators[i] != 1){
                y[i] += 's';
            }
        }
        return y;
    }

    public static void period(){
        LocalDate now = LocalDate.now(), nextChristmas = LocalDate.of(2018, 12, 24);
        System.out.println();
        System.out.println("Next year's christmas is at " + nextChristmas.toString());
        System.out.println("Current date is " + now.toString());

        Period period = Period.between(now, nextChristmas);

        String [] times = multipleUnits(period.getYears(), period.getMonths(), period.getDays());

        System.out.printf("From now, it is %d %s, %d %s and %d %s until then. ",
                           period.getYears(),times[0], period.getMonths(),times[1], period.getDays(), times[2]);
        System.out.println("All in all, that is in " + ChronoUnit.DAYS.between(now, nextChristmas) + " days!");


    }
}
