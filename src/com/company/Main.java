package com.company;

import com.company.week1.day2.Exercises1to4;
import com.company.week1.day2.challenge1.Calculator;
import com.company.week1.day3.Exercise5;
import com.company.week1.day4.BinaryToInt;
import com.company.week1.day4.terminal.ChessBoard;
import com.company.week1.day4.Exercise6;
import com.company.week1.day4.Exercise7;
import com.company.week1.day4.terminal.RandomBoard;
import com.company.week2.day1.Module8;

import java.io.FileNotFoundException;

public class Main {

    static public boolean willSleep = !true;
    static Exercises1to4 run = new Exercises1to4();
    static String [] file = {"C:\\Users\\Administrator\\IdeaProjects\\Exercises\\src\\com\\company\\hello.txt",
                            "c:\\workspace\\temp\\testwriter.txt"};

    static int runtime = 15;
    static int alternative = 9;

    public static void main(String[] args)throws FileNotFoundException {

        switch (runtime){
            case 0: run.readFile(file[0]);
                    break;
            case 1: run.printToFile(file[1]);
                    break;
            case 2: run.scannerExercise();
                    break;
            case 3: Calculator.doCalculation();
                    break;
            case 4: Exercise5.run(alternative);
                    break;
            case 5: Exercise6.printColorStrings('a');
                    break;
            case 6: Exercise7.outPutKeyValuesOf(Exercise7.input);
                    break;
            case 7: Exercise7.findEven(Exercise7.input);
                    break;
            case 8: BinaryToInt.toIntV2("10000000");
                    BinaryToInt.toIntV2("00000001");
                    BinaryToInt.toIntV2("00001111");
                    BinaryToInt.toIntV2("1111111111111111");
                    break;
            case 9: ChessBoard.run(); break;
            case 10: RandomBoard.run(); break;
            case 11: Exercise7.sumOfNumbers(); break;
            case 12: Module8.ex8_1_2(); break;
            case 13: Module8.ex8_1_5(); break;
            case 14: Module8.ex8_2_1(); break;
            case 15: Module8.printHTML(); break;
        }
    }
}
