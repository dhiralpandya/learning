package com.omt.learn.geekforgeek.dynamic;

public class LIS {

    public static void main(String args[]) {

        int a[] = {3, 10, 2, 1, 20};
        System.out.println(lis(a,0));

        int b[] = {3, 2};
        System.out.println(lis(b,0));

        int c[] = {50, 3, 10, 7, 40, 80};
        System.out.println(lis(c,0));

        int d[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(d,0));

    }



    public static  int lis(int a[], int start) {

        int end = a.length-1;

        if(start >= end) {
            return 1;
        }

        int maxLIS = 1;

        for(int index = start+1; index <= end; index++){
            //Check what we have for next element. Calculate LIS for next element.
            int tempLIS = lis(a,index); //For input {50, 3, 10, 7, 40, 80}

            //Take start element and compare with all next selections.
            if(a[start] < a[index]) {
                tempLIS++; //Increase If start is less than neighbor
            }

            if(tempLIS > maxLIS) {//If tempLIS is greater than MaxLis
                maxLIS = tempLIS;
            }
        }

        return maxLIS;
    }

}
