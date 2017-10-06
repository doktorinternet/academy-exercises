package com.company;

public class Timer {
    long startTime;
    long endTime;

    public void startTimer(){
        startTime = System.currentTimeMillis();
    }

    public void endTimer(){
        endTime = System.currentTimeMillis();
    }

    public void printTime(String flair){
        System.out.printf("%n%s: %d ms", flair, endTime - startTime);
    }
    public void printTime(){
        System.out.printf("%nTime passed: %d ms", endTime - startTime);
    }

    public long getTime(){
        return endTime - startTime;
    }
}

