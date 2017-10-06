package com.company.week2.day1;

import com.company.week1.day3.challenge2.IntFinder;

import java.util.Scanner;

public class Receipt {

    private static final double foodTax = 1.1, normalTax = 1.25;

    private int quantity;
    private double incTaxPrice, amountTax, exTaxPrice, pricePerUnit;
    private String productName;

    private boolean isFoodItem;

    public static void main(String[] args) {
    }

    public Receipt(){
        Scanner read = new Scanner(System.in);
        System.out.print("Enter the product name: ");
        setProduct(read.nextLine());
        System.out.print("Enter price per item: ");
        setPricePerUnit(Double.parseDouble(read.nextLine().trim()));
        System.out.print("Enter amount of items: ");
        setQuantity(Integer.parseInt(read.nextLine().trim()));
        System.out.print("Is the item a food? (y/n) ");
        setIsFoodItem(read.nextLine());
        calculateReceipt();
    }


    private void calculateReceipt(){
        setTotalPrice();
        setIncTaxPrice();
    }



    public void printNicely(){
        System.out.println();
        System.out.println("------------------ Receipt ------------------");
        System.out.printf(" Product: %34s%n", this.productName);
        System.out.println();
        System.out.printf(" Total amount to pay, excluding tax: %7.2f%n", this.exTaxPrice);
        System.out.printf(" Total amount to pay, including tax: %7.2f%n", this.incTaxPrice);
        System.out.printf(" Of which, tax is: %25.2f%n", this.amountTax);
        System.out.println("---------------------------------------------");
    }

    private void setProduct(String p){ productName = p;}

    private void setPricePerUnit(double p){pricePerUnit = p;}

    private void setQuantity(int q){quantity = q;}

    private void setIsFoodItem(String f){
        isFoodItem = f.equals("y");
    }

    private void setTotalPrice(){
        this.exTaxPrice = this.pricePerUnit * this.quantity;
    }

    private void setIncTaxPrice(){
        if(isFoodItem) {this.incTaxPrice = exTaxPrice * foodTax;}
        else {this.incTaxPrice = this.exTaxPrice * normalTax;}
        this.amountTax = this.incTaxPrice - this.exTaxPrice;
    }

}
