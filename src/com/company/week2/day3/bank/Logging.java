package com.company.week2.day3.bank;

public class Logging {

    private String logString;
    private boolean successful = true;
    private String path = "./log.txt";

    Logging(){
        logString = "Bank auditlog".concat("\r\n");
        FileWriter.toFile(logString, FileWriter.LOG);
    }

    void deposit(int amount, String fromAccount, String toAccount){
        FileWriter.toFile("Doing a desposit of " + amount + " Sek from "
                + fromAccount + " to " + toAccount + "\r\n", FileWriter.LOG);
    }

    void cost(int paymentCost){
        FileWriter.toFile("Payment cost" + paymentCost + "\r\n", FileWriter.LOG);
    }
}

