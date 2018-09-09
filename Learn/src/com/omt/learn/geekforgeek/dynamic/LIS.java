package com.omt.learn.geekforgeek.dynamic;

public class LIS {


    private static long startTime = 0;
    private static long MAX_LIS = 0;

    public static void main(String args[]) {
        setStartTime();
        int a[] = {3, 10, 2, 1, 20};
        MAX_LIS = 0;
        lis(a, 0);
        System.out.println(MAX_LIS);

        int b[] = {3, 2};
        MAX_LIS = 0;
        lis(b, 0);
        System.out.println(MAX_LIS);

        int c[] = {50, 3, 10, 7, 40, 80};
        MAX_LIS = 0;
        lis(c, 0);
        System.out.println(MAX_LIS);

        int d[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        MAX_LIS = 0;
        lis(d, 0);
        System.out.println(MAX_LIS);


        int e[] = {0, 8, 4, 12, 2, 10};
        MAX_LIS = 0;
        lis(e, 0);
        System.out.println(MAX_LIS);

        int f[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        MAX_LIS = 0;
        lis(f, 0);
        System.out.println(MAX_LIS);

        calculateEndTime();
    }


    public static int lis(int a[], int start) {

        int end = a.length - 1;

        if (start >= end) {
            return 1;
        }

        int maxLIS = 1;

        for (int index = start + 1; index <= end; index++) {
            //Check what we have for next element. Calculate LIS for next element.
            int tempLIS = lis(a, index); //For input {50, 3, 10, 7, 40, 80}

            //Take start element and compare with all next selections.
            if (a[start] < a[index]) {
                tempLIS++; //Increase If start is less than neighbor

                //Calculation of current element  maxLIS for current index. This if inside above if {0, 8, 4, 12, 2, 10}
                if (tempLIS > maxLIS) {//If tempLIS is greater than MaxLis
                    maxLIS = tempLIS;
                }
            }


        }
        MAX_LIS = MAX_LIS < maxLIS ? maxLIS : MAX_LIS;
        return maxLIS;
    }

    private static void setStartTime() {
        startTime = System.currentTimeMillis();
    }

    private static void calculateEndTime() {
        System.out.println("Time in ms:" + (System.currentTimeMillis() - startTime));
    }
}
