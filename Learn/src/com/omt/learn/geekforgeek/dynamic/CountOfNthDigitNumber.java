package com.omt.learn.geekforgeek.dynamic;

public class CountOfNthDigitNumber {

    public static void main(String args[]) {
        //OMT
        System.out.println(count(2,2,2,0));
        System.out.println(count(2,5,2,0));
        System.out.println(count(3,6,3,0));
    }

    public static int count(int n, int sum, int remainingCount, int currentSum) {
        if(remainingCount == 0) {
            return 0;
        }
        
        boolean isFirstTime = remainingCount == n;
        int start = isFirstTime?1:0;
        boolean checkCalculation = remainingCount == 1;
        int totalCount = 0;
        
        for(int i = start; i <= 9; i++) {
            if(checkCalculation) {
                if(currentSum+i == sum){
                    totalCount++;
                }
            } else {
                totalCount+=count(n,sum,remainingCount-1,currentSum+i);
            }
        }
        
        return totalCount;
    }
}
