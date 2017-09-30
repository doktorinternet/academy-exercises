package com.company.week1.day2.challenge1;

class SimpleCache {

    private CacheData[] cd;
    private static int indexer = 0;
    private static int slot = 0;

    public SimpleCache(int capacity){
        cd = new CacheData[capacity];
    }

    private void setRelevantSlot(int s){
        slot = s;
    }

    CacheData [] getCacheData(){
        return cd;
    }

    private int getCachedResult(){
        return cd[slot].result;
    }

    void setCacheData(int input, int result){
        cd[input] = new CacheData(input, result);
        //if (indexer < cd.length) indexer++;
    }

    private boolean alreadyExists(int input){
        int i = 0;
        for(CacheData c : getCacheData()) {
            if( c != null){
                if (c.input == input) {
                    setRelevantSlot(i);
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    int calculate(int randValue){
        if (alreadyExists(randValue)) {
            System.out.println("Using cached data");
            return this.getCachedResult();
        } else {
            return new Calculator().doComplexCalculation(randValue);
        }
    }

    void printTable(CacheData [] cd){
        System.out.println("Finally, the CacheData array has values: \n" +
                "Slot  Input  Result");
        int i = 0;
        for (CacheData c : cd){
            System.out.printf("%4d %6d %7d%n", i, c.input, c.result);
            i++;
        }
    }
}

