package com.omt.learn.geekforgeek.dynamic;

public class NumBinaryStringWithoutCon1 {

    public static void main(String args[]) {
        System.out.println(findCount(5));
    }


    public static int findCount(int n) {
        int lastCount = 1;
        int lastLastCount = 1;

        for (int i = 1; i <= n; i++) {
            int tempLastCount = lastCount;
            lastCount = lastCount + lastLastCount;
            lastLastCount = tempLastCount;
        }

        return lastCount;
    }


}
