package com.company.week1.day3;

import com.company.week1.day2.challenge1.CacheData;
import com.company.week1.day3.challenge2.IntFinder;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Exercise5 {

    public static void run(int exercise){

        IntFinder finder = new IntFinder();
        //System.out.println(finder.isANumber("5"));

        switch (exercise){
            case 0: break;
            case 1: incrementalOperators1(); break;
            case 2: incrementalOperators2(); break;
            case 3: isEven(new Random().nextInt(10)); break;
            case 4: fizzBuzz(); break;
            case 5: ifLogic(); break;
            case 6: forloop(); break;
            case 7: stringToInt(); break;
            case 8: finder.findInt("3490230 bjfwlj444");
        }
    }

    private static void incrementalOperators1(){
        int x = 42;

        System.out.println(x);
        System.out.println(x++);
        System.out.println(x);
        System.out.println(++x);
        System.out.println(x);
    }

    private static void incrementalOperators2(){
        int x=42;
        int y = 0;
        while (y < 100){
            y = x++;
            System.out.println(y);
            y = x;
            System.out.println(y);
        }
    }

    private static void isEven(int x){
        if (x % 2 == 0) System.out.println(x + " is even, babyyyy");
        else System.out.println(x + " can't even :(");
    }

    static void fizzBuzz(){
        String s = "";
        for(int i = 1; i <= 100; i++){
            if (i % 3 == 0) s = s.concat("Fizz");
            if (i % 5 == 0) s = s.concat("Buzz");
            if (!( i % 3 == 0 || i % 5 == 0)) s = s.concat(i + "");
            s = s.concat("\n");
        }
        System.out.println(s);
    }

    private static void ifLogic(){
        for(int i=0;i<100;i++)
        {
            if(!(i<5 || i>10))
            {
                System.out.println(i);
            }
        }
    }

    // Varför skriva samma loop om och om igen?
    private static void forloop(){
        for(int i = 0; i < 100; i++){
            ifLogicAdv2(i);
        }
    }

    static void ifLogicAdv1(int i){
        if (i > 4 && i < 11 ^ i == 42){
            System.out.println(i);
        }
    }

    private static void ifLogicAdv2(int i){
        if (!(i < 5 || i > 10 ^ i == 42)){
            System.out.println(i);
        }
    }

    private static void intToString(){

    }

    private static void stringToInt(){
        String s = new Scanner(System.in).next();
        Scanner sc = new Scanner(s);
        int result = 0;

        if (sc.hasNext()){
            try {
                result = sc.nextInt();
                System.out.println(result);
            }catch(InputMismatchException i){
                System.out.println("Couldnt find an integer");
            }
        }else System.out.println("Nope");
    }


}



/**
 * One hell of an ugly, and also worthless class, but I just dont have the heart to kill it yet.
 */

class NumberAssembler{

    int numLength;
    String numberString = "";
    int result;

    NumberAssembler(ArrayList<CacheData> c){
        for ( CacheData cd : c){
            if(cd.character != null){
                System.out.println(cd.character);
                numberString = numberString.concat(cd.character);
            }
        }
        numLength = numberString.length();
    }

    int assemble(){
        int temp;
        for(int i = numLength; i >= 0; i-- ){
            result = (int) numberString.charAt(i);
            if(i == numLength-1){
                temp = 10 * (int) numberString.charAt(i);
                result += temp;
            }
            if(i == numLength-2){
                temp = 100 * (int) numberString.charAt(i);
                result += temp;
            }
            if(i == numLength-3){
                temp = 1000 * (int) numberString.charAt(i);
                result += temp;
            }
            if(i == numLength-4){
                temp = 10000 * (int) numberString.charAt(i);
                result += temp;
            }
            if(i == numLength-5){
                temp = 100000 * (int) numberString.charAt(i);
                result += temp;
            }
            if(i == numLength-6){
                temp = 1000000 * (int) numberString.charAt(i);
                result += temp;
            }
            if(i == numLength-7){
                temp = 10000000 * (int) numberString.charAt(i);
                result += temp;
            }
            if(i == numLength-8){
                temp = 100000000 * (int) numberString.charAt(i);
                result += temp;
            }
        }
        return result;
    }

}