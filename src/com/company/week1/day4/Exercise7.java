package com.company.week1.day4;

import com.company.ToolBox;
import java.util.Scanner;

public class Exercise7 {

    public static int[] input = {1, 4, 5, 7, 20000, -511, 100, -200, 400};

    static ToolBox omniTool = ToolBox.getOmniTool();

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

    private static int sumOfArray(int[] input){
        int sum = 0;
        for (int i : input){
            sum += i;
        }
        return sum;
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

    public static void sumOfNumbers(){ //return type int

        System.out.println("Exit program by typing a letter instead of a number\n");
        do {
            // Reset variables each run
            int result, min = 0, max;
            String input;
            Scanner read;

            // Read user input
            System.out.print("Enter one or two numbers, separated by space: ");
            read = new Scanner(System.in);
            input = read.nextLine();

            // Check if user is done
            if (!omniTool.isANumber(input.substring(0,1))) {
                System.out.println("Input is not a number, terminating application");
                System.exit(0);
            }

            read = new Scanner(input);
            result = 0;
            max = Integer.parseInt(read.next());

            // Check if user entered two numbers
            if (read.hasNext()){
                min = Integer.parseInt(read.next());

                // Make sure max contains the highest of the two
                if (min > max){
                    int tmp = min;
                    min = max;
                    max = tmp;
                }
            }

            StringBuilder print = new StringBuilder("Sequence: ");

            // Loop calculation
            for (; min <= max; min++){
                result += min;
                if( min < max)print.append(min).append(" + ");
                if( min == max)print.append(min).append(" = ").append(result);
            }

            System.out.println(print);
            System.out.println();

            read.close();
        }while (true);//!(new Scanner(System.in).next().equalsIgnoreCase("q")));

        //return result;
    }
}
