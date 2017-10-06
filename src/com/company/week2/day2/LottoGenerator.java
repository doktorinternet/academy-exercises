package com.company.week2.day2;

import java.util.Random;

public class LottoGenerator {

    private int [] generateNumbers(int amount){
        int [] randomInts = new int[amount];
        int range = 35;
        for ( int i = 0; i < randomInts.length; i++){
            randomInts[i] = new Random().nextInt(range)+1;
        }
        return randomInts;
    }

    private boolean containsDuplicates(int [] input){
        // Make sure no two numbers on the same index are compared
        int indexDecider = 1;
        // Loop through array at least once per int to crosscheck
        for (int random : input){
            for (int index = indexDecider; index < input.length ; index++ ){
                if( input[index] == random){
                    return true;
                }
            }
            indexDecider++;
        }
        return false;
    }

    private int getOneRandomNumber(int range, int[] input){
        Random rand = new Random();
        int random = rand.nextInt(range)+1;
        for(int i = 0; i < input.length; i++){
            while (i == random){
                random = rand.nextInt(range)+1;
                i = 0;
            }

        }
        return random;

    }

    public int [] getRandomNumbers(int amount, int range){
        int [] randomArray = new int[amount];

        for(int i = 0; i<randomArray.length; i++) {
            randomArray[i] = getOneRandomNumber(range, randomArray);
        }

        return randomArray;
    }

}