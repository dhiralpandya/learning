package com.omt.learn.geekforgeek.dynamic;

public class CuttingTheRod {


    public static void main(String args[]) {
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Max Price:" + maxPrice(arr, arr.length));

        int arr2[] = new int[]{3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Max Price:" + maxPrice(arr2, arr2.length));
    }

    public static int maxPrice(int a[], int remaining) {


        if (remaining <= 0) {
            return 0;
        }

        int max = 0;

        for (int i = 0; i < a.length; i++) {
            int left = remaining - i - 1;
            if (left >= 0) {
                max = Math.max(max, a[i] + maxPrice(a, left));
            }

        }

        return max;

    }

}
