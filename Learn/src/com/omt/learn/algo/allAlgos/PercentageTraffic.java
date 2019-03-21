package com.omt.learn.algo.allAlgos;

import java.util.Random;

public class PercentageTraffic {
    
    public static void main(String...args){
        
        int per = 0;
        for(int i = 0; i < 10000;i++){
            if(divertByPercentage(85)){
                per++;
            }
        }
        System.out.println("Total Redirect:"+per);
        System.out.println("Percentage:"+((per*100)/10000));
    }
    
    public static boolean divertByPercentage(int percentage) {
        Random random = new Random();
        int i = random.nextInt(100)+1;
        return i <= percentage;
    }
    
}
