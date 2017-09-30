package com.company.week1.day4;

public class BinaryToInt {

    public static int toInt(String theByte){

        int [] bits = new int[theByte.length()];
        int currentBitValue = 1;
        int sum = 0;

        // fyll array med motsvarande binärvärden, 1,2,3,8,16 osv
        for (int i = bits.length-1; i >= 0; i--){
            bits[i] = currentBitValue;
            currentBitValue = currentBitValue*2;
        }



        // Utför översättning
        for(int i = bits.length -1; i >= 0; i--){
            if(theByte.charAt(i) == '1'){
                sum += bits[i];
            }
        }
        System.out.println(theByte + " translates to " + sum);
        return sum;
    }

    public static void toIntV2(String theByte){

        int currentBitValue = 1;
        int sum = 0;
        // fyll array med motsvarande binärvärden, 1,2,3,8,16 osv
        for (int i = theByte.length()-1; i >= 0; i--){
            if(theByte.charAt(i) == '1'){
                sum += currentBitValue;
            }
            currentBitValue = currentBitValue*2;
        }
        System.out.println(theByte + " translates to " + sum);
        return; // sum
    }

}
