package com.company;

import com.company.week1.day2.Exercises1to4;
import com.company.week1.day3.Exercise5;
import com.company.week1.day4.BinaryToInt;
import com.company.week1.day4.terminal.ChessBoard;
import com.company.week1.day4.Exercise6;
import com.company.week1.day4.Exercise7;
import com.company.week1.day4.terminal.RandomBoard;
import com.company.week2.day1.Module8;
import com.company.week2.day1.Module9;
import com.company.week2.day1.Receipt;
import com.company.week2.day2.ArrayHelper;
import com.company.week2.day2.BubbleSort;
import com.company.week2.day2.LottoGenerator;
import com.company.week2.day2.SearchUsers;
import com.company.week2.day3.Objects;
import com.company.week2.day3.bank.BankMain;
import com.company.week2.day3.car.Car;

import java.io.FileNotFoundException;

public class Main {

    static public boolean willSleep = !true;
    static Exercises1to4 run = new Exercises1to4();
    static String [] file = {"C:\\Users\\Administrator\\IdeaProjects\\Exercises\\src\\com\\company\\hello.txt",
                            "c:\\workspace\\temp\\testwriter.txt"};

    static int runtime = 6;
    static int alternative = 9;
    static int iterations = 20;

    public static void main(String[] args)throws FileNotFoundException {
        int [] test = {10, 20, 30, -59};
        BubbleSort bubble = new BubbleSort();
        LottoGenerator lg = new LottoGenerator();
        ArrayHelper arrayHelper = new ArrayHelper();
        Timer timer = new Timer();
        SearchUsers userSearch = new SearchUsers();

        switch (runtime){

            case 0:
                    System.out.println(arrayHelper.sumArray(test));
                    System.out.println(arrayHelper.minNumber(test));
                    System.out.println(arrayHelper.maxNumber(test));
                    break;

            case 1:
                for(int i = 0; i < iterations; i++){
                    for (int p: lg.getRandomNumbers(7, 35)){
                        System.out.printf("%2d   ", p);
                    }
                    System.out.println();
            }
            break;
            case 2:

                lg = new LottoGenerator();
                timer.startTimer();
                int [] arr = bubble.sortArray(lg.getRandomNumbers(1000, 1000));
                for (int p = 0; p <  arr.length; p++){
                    System.out.printf("%3d ", arr[p]);
                    if (p % 15 == 0) System.out.println();
                }
                timer.endTimer();
                timer.printTime("while generating");
                break;

//region Cases
            case 3: userSearch.initUsers();
                break;
            case 4: Objects.run();
                    break;
            case 5: Car.run();
                    break;
            case 6:
                BankMain.run();
                break;
            case 7: Exercise7.findEven(Exercise7.input);
                    break;
            case 8: BinaryToInt.toIntV2("10000000");
                    BinaryToInt.toIntV2("00000001");
                    BinaryToInt.toIntV2("00001111");
                    BinaryToInt.toIntV2("1111111111111111");
                    break;
            case 9: ChessBoard.run();
                    break;
            case 10: RandomBoard.run();
                     break;
            case 11: Exercise7.sumOfNumbers();
                     break;
            case 12: Module8.ex8_1_2();
                     break;
            case 13: Module8.ex8_1_5();
                     break;
            case 14: Module8.ex8_2_1();
                     break;
            case 15: Module8.printHTML();
                     break;

            case 16: Receipt receipt = new Receipt();
                receipt.printNicely();
                break;
            case 17: Module8.randomTest();
                break;
            case 18: Module9.period();
                break;
                //endregion
        }
    }
}
