package com.omt.learn.geekforgeek.dynamic;

import java.util.Arrays;

public class CountOfNDigitNumber {

    public static void main(String args[]) {

//        System.out.println(findCount(2, 2, 0));
//        System.out.println(findCount(2, 5, 0));
//        System.out.println(findCount(3, 6, 0));

//        System.out.println(findCountDP(2, 2));
//        System.out.println(findCountDP(2, 5));
        System.out.println(findCountDP(3, 6));
    }

    public static int findCount(int n, int sum, int tempSum) {
        if (n == 0) {
            if (tempSum == sum) {
                return 1;
            } else {
                return 0;
            }
        }

        int totalCount = 0;
        //If its a first time then start with 1
        int startWith = tempSum == 0 ? 1 : 0;

        for (int i = startWith; i <= 9; i++) {
            totalCount += findCount(n - 1, sum, tempSum + i);
        }

        return totalCount;
    }

    public static int findCountDP(int n, int sum) {
        int totalCount = 0;

        for (int i = 1; i <= 9; i++) {
            int result[] = new int[10];

            for (int remaining = n - 1; remaining > 0; remaining--) {

                boolean isLastIteration = remaining == 1;
                boolean isFirstTime = remaining == n - 1;

                for (int j = 0; j <= 9; j++) {

                    if (isFirstTime) {
                        result[j] += i;
                    }

                    result[j] += j;


                    if (isLastIteration && result[j] == sum) {
                        totalCount++;
                    }
                }

            }

            System.out.println(Arrays.toString(result));

        }

        return totalCount;
    }
}
