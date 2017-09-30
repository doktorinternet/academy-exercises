package com.company.week1.day2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Exercises1to4 {

    Scanner input;

    public Exercises1to4(){}


    void exercise3(){
        int sum = 4 + 5;
        String name = "Java";
        int x = 12;
        int y = 345;
        int z = 6789;
        float f = 3.14f;

        System.out.printf("%04d%n" + "%04d%n" + "%04d%n", x, y, z);
    }

    public void scannerExercise(){
        System.out.println("Please enter three numbers, one per row:");
        System.out.printf("%d %d %d", getInt(), getInt(), getInt());
    }

    int getInt(){
        int x = 0;
        input = new Scanner(System.in);
        try{
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

    public void readFile(String filePath) throws FileNotFoundException{
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
        String str = "This is the story all about how my life was twisted upside down, now, i'd like to "
                .concat("take a minute, just sit right there, and ill tell you how i became the prince ")
                .concat("of bel air EXIT detta ska inte finnas med i filen!");
        input = new Scanner(System.in);
        String temp = "";
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
}
