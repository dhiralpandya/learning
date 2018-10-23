package com.omt.learn.geekforgeek.dynamic;

import java.util.Arrays;

public class MaxSumSubArray {

    public static void main(String args[]) {
        //OMT
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArray(a));
    }
    
    
    public static int maxSubArray(int a[]) {
        int maxSum =  a[0];
        int start = 0;
        int end = 0;
        int cache[] = new int[a.length];
        cache[0] = a[0];
        
        for(int i = 1; i < a.length; i++) {
            int tempSum = cache[i-1]+a[i];
            cache[i] = a[i];
            
            if(tempSum > maxSum && a[i] < tempSum) {
                maxSum=tempSum;
                cache[i] = maxSum;
                end = i;
            } else if(a[i] > maxSum) {
                maxSum = a[i];
                start = end = i;
                cache[i] = a[i];
            }
            
            if(tempSum > a[i]) {
                cache[i] = tempSum;
            } 
        }

        System.out.println("Start "+start+" and End "+end+"");
        System.out.println(Arrays.toString(cache));
        return  maxSum;
    }

}
