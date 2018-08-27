package com.omt.learn.geekforgeek.dynamic;

import java.util.Map;
import java.util.TreeMap;

public class LIS2 {


    private static long startTime = 0;



    public static void main(String args[]) {
        setStartTime();
        int a[] = {3, 10, 2, 1, 20};
        System.out.println(lis(a,0,new TreeMap<>()));

        int b[] = {3, 2};
        System.out.println(lis(b,0,new TreeMap<>()));

        int c[] = {50, 3, 10, 7, 40, 80};
        System.out.println(lis(c,0,new TreeMap<>()));

        int d[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(d,0,new TreeMap<>()));
        calculateEndTime();
    }



    public static  int lis(int a[], int start, Map<Integer,Integer>  CALCULATED_RESULT ) {

        int end = a.length-1;

        if(start >= end) {
            return 1;
        }

        int maxLIS = 1;

        for(int index = start+1; index <= end; index++){
            //Check what we have for next element. Calculate LIS for next element.
            int tempLIS = 1;
            //This way we can avoid calling same method again and again, which is more safe to avoid stackoverflow exception.
            if(CALCULATED_RESULT.containsKey(index))
            {
                tempLIS = CALCULATED_RESULT.get(index);
            }else {
                tempLIS = lis(a,index,CALCULATED_RESULT); //For input {50, 3, 10, 7, 40, 80}
            }


            //Take start element and compare with all next selections.
            if(a[start] < a[index]) {
                tempLIS++; //Increase If start is less than neighbor
            }

            if(tempLIS > maxLIS) {//If tempLIS is greater than MaxLis
                maxLIS = tempLIS;
            }
        }

        CALCULATED_RESULT.put(start,maxLIS);
        return maxLIS;
    }


    private static  void setStartTime(){
        startTime = System.currentTimeMillis();
    }

    private  static  void calculateEndTime() {
        System.out.println("Time in ms:"+(System.currentTimeMillis()-startTime));
    }


}
