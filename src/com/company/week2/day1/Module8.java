package com.company.week2.day1;


public class Module8 {

    private static char[] a = {'J', 'a', 'v', 'a', 'R', 'u', 'l', 'e', 's'};

    public static void ex8_1_1(){

        for (int i = a.length-1; i >= 0; i--){
            System.out.print(a[i]);
        }
    }

    public static void ex8_1_2(){

        for (int i = 0; i < a.length; i = i + 2){
            System.out.print(a[i]);
        }

    }

    public static void ex8_1_3(){
        String javaR = "";

        // W/o StringBuilder
        for (int i = 0; i < a.length; i++){
            javaR = javaR.concat(a[i] + "");
        }

        StringBuilder builder = new StringBuilder();

        for ( int i = 0; i < a.length; i++){
            builder.append(a[i]);
        }

        System.out.println("String: ".concat(javaR));
        System.out.println("Builder: ".concat(builder.toString()));
    }

    public static void ex8_1_4(){
        String name = "Java Svensson";

        char [] nameArr = new char[name.length()];

        for ( int i = 0; i < nameArr.length; i++){
            nameArr[i] = name.charAt(i);
        }


        for(char character : nameArr){
            System.out.print(character);
        }
        System.out.println(name);
        System.out.println();
    }

    public static void ex8_1_5(){

        String input = "1,2,4,9,8,7,6,4,1";
        java.util.Scanner read = new java.util.Scanner(input).useDelimiter(",");
        StringBuilder str = new StringBuilder();

        while(read.hasNext()){
            str.append(read.next());
        }

        int [] ints = new int[str.length()];

        for ( int i = 0; i < ints.length; i++){
            ints[i] = Integer.parseInt(str.charAt(i) + "");
            System.out.print(ints[i]);
        }
    }

    public static void ex8_2_1(){
        
    }
}
