package com.omt.learn.geekforgeek.dynamic;

public class CountWayToReachNthStair {

    public static void main(String args[]) {
        
        System.out.println(getCount(1));
        System.out.println(getCount(2));
        System.out.println(getCount(3));
        System.out.println(getCount(4));
        System.out.println(getCount(5));


        System.out.println(getCountDP(1));
        System.out.println(getCountDP(2));
        System.out.println(getCountDP(3));
        System.out.println(getCountDP(4));
        System.out.println(getCountDP(5));

    }
    
    
    
    public static int getCount(int n) {
        if(n==0) {
            return 1;
        } else if(n < 0) {
            return 0;
        }
        
        return getCount(n-1)+getCount(n-2);
    }
    
    public static int getCountDP(int n) {
        if(n < 3) {
            return n;
        }
        
        int lastCount = 2;
        int lastLastCount = 1;
        
        for(int i =0; i < n-2; i++) {
            int temp = lastCount;
            lastCount = lastLastCount+lastCount;
            lastLastCount = temp;
        }
        return lastCount;
    }
    

}
