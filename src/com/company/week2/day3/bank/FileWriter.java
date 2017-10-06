package com.company.week2.day3.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileWriter {

    private static boolean successful = true;
    private static String logPath = "./log.txt";
    private static String receiptPath = "./confirmation.txt";

    public final static int LOG = 0, RECEIPT = 1;

    static void toFile(String textToPrint, int type){

        try{
            if (successful){
                switch (type){
                    case LOG:
                        Files.write(
                            Paths.get(logPath),
                            textToPrint.getBytes(),
                            StandardOpenOption.CREATE);
                        break;
                    case RECEIPT:
                        Files.write(
                            Paths.get(receiptPath),
                            textToPrint.getBytes(),
                            StandardOpenOption.CREATE);
                        break;
                }
            }else{
                System.out.print("Enter new path: ");
                switch (type){
                    case LOG:
                        logPath = new Scanner(System.in).nextLine();
                        break;
                    case RECEIPT:
                        receiptPath = new Scanner(System.in).nextLine();
                        break;
                }
                System.out.println();
                toFile(textToPrint, type);
                successful = true;
            }
        }catch (IOException e){
            System.out.printf("Error: %h%nCouldn't get file %n", e);
            toFile(textToPrint, type);
            successful = false;
        }
    }
}
