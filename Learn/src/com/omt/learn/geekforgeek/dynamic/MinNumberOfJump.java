package com.omt.learn.geekforgeek.dynamic;

import java.util.Arrays;

public class MinNumberOfJump {
    
    public static void main(String args[]) {
        //OMT
        int a[] = {1,3,6,1,0,9};
        System.out.println(minJump(a));

        int b[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJump(b));
    }
    
    
    public static int minJump(int a[]) {
        int FIRST_TIME_CALCULATION = 0;
        
        int result[] = new int[a.length];
        result[0] = 1;
        
        
        
        for(int steps = 0; steps < a.length; steps++) {
            
            int minStep = result[steps]+1;
            int maxMove = a[steps];
            int currentMove = 0;
            int move = 0;
            
            for(move = steps+1;move<a.length && currentMove < maxMove;move++, currentMove++) {
                if(result[move] != FIRST_TIME_CALCULATION){
                    result[move] = Math.min(result[move],minStep);
                }else {
                    result[move] = minStep;
                }
            }
            
            if(move == a.length) {
                System.out.println(Arrays.toString(result));
                return result[a.length-1]-1;
            }
        }
        
        return 0;
        
    }
    
    
    
    
}
