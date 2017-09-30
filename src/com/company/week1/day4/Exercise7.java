package com.company.week1.day4;

import com.company.ToolBox;

public class Exercise7 {

    public static int[] input = {1, 4, 5, 7, 20000, -511, 100, -200, 400};

    static ToolBox omniTool = com.company.ToolBox.getOmniTool();

    public static void outPutKeyValuesOf(int [] input){

        for (int i: getSumMaxMin(input)) System.out.println(i);

    }

    private static boolean isLowerThan(int x, int y){
        return x < y;
    }

    private static int [] getSumMaxMin(int [] input){
        int lowest = 0, highest = 0, sum = 0;

        for ( int ints : input){
            if(isLowerThan(ints, lowest)){
                lowest = ints;
            }
            if(isLowerThan(highest, ints)){
                highest = ints;
            }
            sum += ints;
        }
        return new int[]{sum, highest, lowest};
    }

    private static int [] sortArray(int [] input){
        int remember;
        // Find the lowest integer in array
        for ( int placeIndex = 0 ; placeIndex < input.length; placeIndex++){
            for (int x = placeIndex+1 ; x < input.length; x++){
                if (isLowerThan(input[x], input[placeIndex])){
                    remember = input [placeIndex];
                    input[placeIndex] = input[x];
                    input[x] = remember;
                }
            }
        }

        return input;
    }

    private static int sumOfArray(int[] input){
        int sum = 0;
        for (int i : input){
            sum += i;
        }
        return sum;
    }

    public static void findEven(int [] input){
        int evenNumbers = 0;
        int[] result;
        for(int x : input){
            if(omniTool.isEven(x)){
                evenNumbers++;
            }
        }if(evenNumbers == 0) {
            System.out.println("no even numbers found, terminating");
            return;
        }
        result = new int[evenNumbers];
        int index = 0;
        for(int x : input){
            if(omniTool.isEven(x)){
                result[index] = x;
                index++;
            }
        }
        printArray(result);
    }

    public static void printArray(int [] input) {
        for (int item : input) System.out.println(item);
    }
}
