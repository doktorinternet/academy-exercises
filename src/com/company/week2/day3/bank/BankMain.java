package com.company.week2.day3.bank;

public class BankMain {

    public static void run(){

        Bank bank = new Bank();

        Account account1 = new Account("Jens", 4670);
        Account account2 = new Account("Janne", 44);
        Account account3 = new Account("Jenny", 570);

        bank.sendMoney(1200, account1, account2);
        bank.sendMoney(500, account2, account3);
        bank.sendMoney(2000, account3, account1);

    }
}
