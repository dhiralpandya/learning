package com.omt.learn.geekforgeek.dynamic;

import java.util.Map;
import java.util.TreeMap;

public class LIS3 {


    public static void main(String args[]) {

        int a[] = {3, 10, 2, 1, 20};
        System.out.println(lis(a));

        int b[] = {3, 2};
        System.out.println(lis(b));

        int c[] = {50, 3, 10, 7, 40, 80};
        System.out.println(lis(c));

        int d[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(d));

    }

    private static int lis(int a[]) {
        int maxLIS = 1;

        int end = a.length - 1;

        Map<Integer, Integer> CALCULATED_RESULT = new TreeMap<>();
        CALCULATED_RESULT.put(end, 1); // Last element has 1 as LIS.
        //Here we are using bottom up technique, Starting from bottom we will calculate LIS for each element.
        for (int i = end - 1; i >= 0; i--) {
            CALCULATED_RESULT.put(i, 1);//Default LIS is 1
            for (int j = end; j > i; j--) {//Start with last element and move one by one at top.
                if (a[i] < a[j]
                        && CALCULATED_RESULT.get(i) < (CALCULATED_RESULT.get(j) + 1)) {
                    CALCULATED_RESULT.put(i, CALCULATED_RESULT.get(j) + 1);
                    if (maxLIS < CALCULATED_RESULT.get(i)) {
                        maxLIS = CALCULATED_RESULT.get(i);
                    }
                }
            }
        }

        return maxLIS;
    }
}
