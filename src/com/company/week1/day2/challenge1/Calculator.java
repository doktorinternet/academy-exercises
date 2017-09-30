package com.company.week1.day2.challenge1;

import com.company.Main;

import java.util.Random;

public class Calculator {

    private static SimpleCache cache;

    //Perform a very complex calulation that take 5 seconds to complete
    int doComplexCalculation(int x){

        System.out.println("Expensive calculation: Started for value x = " + x);

        if (Main.willSleep) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.exit(1);
            }
        }

        System.out.println("Expensive calculation: Done");
        cache.setCacheData(x, x*2);
        return x*2;
    }

    public static void doCalculation(){

        int cacheCapacity = 10;
        cache = new SimpleCache(cacheCapacity);

        int maxValue = 10;

        for (int i = 0; i < 1000; i++) {

            int value = new Random().nextInt(maxValue);

            System.out.println("Getting result for value " + value);
            System.out.println("Result: " + cache.calculate(value));
            System.out.println();
        }

        // Ending fluff
        cache.printTable(cache.getCacheData());

    }
}

