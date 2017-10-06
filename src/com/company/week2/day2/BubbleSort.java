package com.company.week2.day2;


import static com.company.ToolBox.getOmniTool;

public class BubbleSort {


    public int [] sortArray(int [] origin){
        long x = java.lang.System.currentTimeMillis();

        // Make sure origin stays unchanged
        int [] result = origin.clone();
        int remember;
        for ( int store = 0 ; store < result.length; store++){
            for (int cycle = store+1 ; cycle < result.length; cycle++){
                if (result[cycle] < result[store]){
                    remember = result [store];
                    result[store] = result[cycle];
                    result[cycle] = remember;
                }
            }
        }

        long y = java.lang.System.currentTimeMillis();
        System.out.println("Time passed in sorting: " + (y-x) + " ms");

        return result;
    }
}
