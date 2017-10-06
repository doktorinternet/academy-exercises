package com.company.week2.day2;

public class ArrayHelper {

    public int minNumber(int [] input){
        int lowest = Integer.MAX_VALUE;
        for ( int ints : input){
            if(ints < lowest){
                lowest = ints;
            }
        }
        return lowest;
    }

    public int maxNumber(int [] input){
        int highest = Integer.MIN_VALUE;
        for ( int ints : input){
            if(highest < ints){
                highest = ints;
            }
        }
        return highest;
    }

    public int sumArray(int[] input){ int sum = 0; for (int i : input) { sum += i; } return sum; }


}
