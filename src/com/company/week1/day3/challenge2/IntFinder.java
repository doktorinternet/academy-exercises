package com.company.week1.day3.challenge2;

public class IntFinder {

    private static String [] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static int findInt(String s){
        System.out.println("your string: " + s);
        String tempNr = "";
        for(int i = 0; i < s.length();){
            while(isANumber(nextLetter(s, i))){
                tempNr = tempNr.concat(nextLetter(s, i));
                System.out.println(tempNr);
                i++;
                if(!isANumber(nextLetter(s, i))) {
                    return makeNumber(tempNr);
                }
            }
            i++;
        }
        return -1;
    }

    private static String nextLetter(String s, int index){
        try{
            if(index+1 <= s.length()){ //s.indexOf(s.substring(index, index+1))
                return s.charAt(index+1) + "";
            }else{
                return "";
            }
        }catch (IndexOutOfBoundsException i){
            return "\r\n";
        }
    }

    private static boolean isANumber(String character){

        if(character == null){
            return false;
        }
        if(character.length() < 1){
            return false;
        }
        for (int i = 0; i < numbers.length; i++){
            if(character.equals(numbers[i])){
                return true;
            }
        }
        return false;
    }

    private static int makeNumber(String s){
        if(s.length() >= 10){
            System.out.println("\nWhoops, number possibly larger than int can handle, not implemented yet");
            System.exit(1);
        }
        System.out.println("This is the number: " + s);
        int temp, diff;
        int result = 0, digits = s.length();
        int [] tiopotens = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        for(int i = digits; i > 0; i--){
            diff = digits - i;
            temp = whatNumber(s.charAt(i-1)) * tiopotens[diff]; // kanske i ska vara i-1
            result += temp;
        }
        return result;
    }

    static int whatNumber(char character){
        int i;
        for (i = 0; i < numbers.length ; i++){
            if(numbers[i].equals(character + "")){
                break;
            }
        }
        return i;
    }
}

/*public void findIntv3(String s){
        System.out.println("your string: " + s); //fj288ouq 9323
        String tempNr = "";
        String tempLetter;
        for(int i = 0; i < s.length(); i++){
            if(isANumber(nextLetter(s, i))){
                tempLetter = nextLetter(s, i);
                System.out.println(tempLetter + " = tempLetter");
                tempNr = tempNr.concat(tempLetter);
                i++;
            }
            if(!isANumber(nextLetter(s, i))) {
                if (tempNr.equals("")) {
                    while(!isANumber(nextLetter(s,i))) i++;
                }else{
                    System.out.println(makeNumber(tempNr));
                }
            }
        }
    }*/
