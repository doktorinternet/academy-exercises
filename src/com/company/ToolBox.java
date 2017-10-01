package com.company;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ToolBox {

    public static ToolBox omniTool = new ToolBox();

    public static ToolBox getOmniTool() {
        return omniTool;
    }

    static String [] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public boolean isEven(int p){
        return p % 2 == 0;
    }

    public void readFile(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));
        String indata = "";
        int i = 1;
        while(input.hasNext()){
            try
            {
                indata = indata.concat(" ".concat(input.nextLine()));
            }
            catch (NoSuchElementException e)
            {
                readFile(filePath);
            }
        }
        System.out.println(indata);
    }

    public void printToFile(String filePath){
        Scanner input = new Scanner(System.in);
        String temp;
        try{
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(
                    filePath)));

            //System.out.println("Enter a little story to save forever <3");
            while(input.hasNext())
            {
                temp = input.next();
                if(!temp.equals("EXIT")){
                    output.print(temp.concat(" "));
                    output.flush();
                    //readFile(filePath);
                }
                else
                {
                    System.exit(0);
                }
            }
            output.close();
        }
        catch (IOException i)
        {
            System.out.println("Couldn't print to file");
            System.exit(1);
        }
    }

    public boolean isLowerThan(int x, int y) {
        return x < y;
    }

    public  boolean isANumber(String character){

        if(character == null){
            return false;
        }
        if(character.length() < 1){
            return false;
        }
        for (String number : numbers) {
            if (character.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public int whatNumber(char character){
        int i;
        for (i = 0; i < numbers.length ; i++){
            if(numbers[i].equals(character + "")){
                break;
            }
        }
        return i;
    }

    public int getInt(){
        int x = 0;
        Scanner input = new Scanner(System.in);
        try{
            System.out.print("Please enter an integer and press return: ");
            x = input.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Whoops, that wasnt an integer, try again:");
            return getInt();
        }catch (NoSuchElementException e){
            System.out.println("Vafan händer här");
            return getInt();
        }
        return x;
    }

    public static int [] sortArray(int [] input){
        int remember;
        // Find the lowest integer in array
        for ( int placeIndex = 0 ; placeIndex < input.length; placeIndex++){
            for (int x = placeIndex+1 ; x < input.length; x++){
                if (omniTool.isLowerThan(input[x], input[placeIndex])){
                    remember = input [placeIndex];
                    input[placeIndex] = input[x];
                    input[x] = remember;
                }
            }
        }

        return input;
    }

}
