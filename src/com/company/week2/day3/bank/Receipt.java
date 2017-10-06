package com.company.week2.day3.bank;

import java.time.LocalDateTime;

public class Receipt {

    void make(int amount, int paymentCost, String fromAccount, String toAccount){
        FileWriter.toFile("Bank transfer receipt\r\n" +
                "\r\nDate: " + LocalDateTime.now() +
                "\r\nAmount:" + amount +
                "\r\nCost: " + paymentCost +
                "\r\nFrom account:" + fromAccount +
                "\r\nTo account:" + toAccount + "\r\n", FileWriter.RECEIPT);
    }
}