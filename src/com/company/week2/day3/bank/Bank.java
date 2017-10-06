package com.company.week2.day3.bank;

public class Bank {

    Logging log = new Logging();
    Receipt receipt = new Receipt();

    public void sendMoney(int amount, Account fromAccount, Account toAccount){

        //Calculate the transfer cost
        int paymentCost = transferCost(amount);

        // Doing the bank transfer somehow....
        if(transfer(amount, paymentCost, fromAccount, toAccount)){
            // Write to a log file for debugging purposes
            log.deposit(amount, fromAccount.accountName, toAccount.accountName);
            log.cost(paymentCost);
            // save a receipt to disk
            receipt.make(amount, paymentCost, fromAccount.accountName, toAccount.accountName);
        }else{
            System.out.println("Not enough funds in account: " + fromAccount.toString());

        }

    }

    private int transferCost(int amount){
        if (amount > 1000) {
            System.out.printf("Payment cost %d%n", 50);
            return 50;
        }
        else{
            System.out.printf("Payment cost %d%n", 10);
            return 10;
        }
    }

    private boolean transfer(int amount, int paymentCost, Account fromAccount, Account toAccount){
        return fromAccount.transferTo(toAccount, amount, paymentCost);
    }

}

class Account{

    static int ID;
    int accountID;
    String accountName;
    int currentAmount;
    String holderId;

    Account(String holderId, int depositedAmount){
        ID++;
        accountID = ID;
        this.holderId = holderId;
        accountName = holderId + "-ACNR-" + accountID;
        currentAmount = depositedAmount;
    }

    boolean transferTo(Account to, int amount, int paymentCost){
        if(currentAmount - (amount+paymentCost) > 0){
            to.currentAmount += amount;
            currentAmount -= (amount+paymentCost);
            return true;
        }else
            return false;
    }

    @Override
    public String toString() {
        return accountName + " current balance: " + currentAmount + "\n";
    }
}