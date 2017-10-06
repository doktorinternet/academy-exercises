package com.company.week2.day1;

import com.company.ToolBox;

import java.util.Random;

public class Module8 {

    static ToolBox tb = ToolBox.getOmniTool();
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
        // W/o StringBuilder
        String javaR = "";
        for (int i = 0; i < a.length; i++){
            javaR = javaR.concat(a[i] + "");
        }

        StringBuilder builder = new StringBuilder();
        for ( int i = 0; i < a.length; i++){
            builder.append(a[i]);
        }

        String s = new String(a);

        System.out.println("String: ".concat(javaR));
        System.out.println("new String: ".concat(s));
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
    } // Använd toCharArray(String s);

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
    } // Använd split(",");

    public static void ex8_2_1(){ // print ASCII Table

        int start = 33;
        char c;
        String hex = "";
        System.out.println("Printing ASCII values: ");
        for(int row = 0; row <= 15; row++){
            for(int i = row; i <= 256; i = i + 15) {
                c = (char) start;
                System.out.printf("%-5d %-5c", start, c);
                start++;
            }
            System.out.println();
        }
    }


    static String getCorrectColor(int x){
        String black = "#ffffff", white = "#cccccc";
        if(tb.isEven(x)) return black;
        else return white;
    }

    public static void printHTML(){

        int cells = 2, rows = 10;

        StringBuilder HTML = new StringBuilder();
        HTML.append("<table>\n");
        for ( int x = 0; x < rows; x++) {
            HTML.append("\t<tr bgcolor=\"")
                .append(getCorrectColor(x))
                .append("\">\n");
            for(int i = 0; i <= cells; i++){
                HTML.append("\t\t<td>")
                    .append("Row ")
                    .append(x+1)
                    .append(" cell ")
                    .append(i+1)
                    .append("</td>\n");
            }
            HTML.append("\t</tr>\n");
        }
        HTML.append("</table>");
        System.out.println(HTML);
    }

    public static void randomTest(){
        Random rand = new Random(-229985452);
        for(int i=0;i<5;i++) {
            int r=96 + rand.nextInt(27);
            char c = (char)r;
            System.out.print(c);
        }
        rand = new Random(-147909649);
        for(int i=0;i<5;i++) {
            int r=96 + rand.nextInt(27);
            char c = (char)r;
            System.out.print(c);
        }

    }
}
