package com.omt.learn.leetcode.google;

/***
 * Description
 * <p>
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Example 1:
 * <p>
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1 // return 1.00000
 * m.next(10) = (1 + 10) / 2 // return 5.50000
 * m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
 * m.next(5) = (10 + 3 + 5) / 3 // return 6.00000
 **/
public class MovingAverage346 {

    public static void main(String args[]) {
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
    }


    static class MovingAverage {
        int windowSize = 0;
        int cache[];
        int index;
        int currentTotal = 0;
        int size = 0; //Starts with zero and increase by one before divide

        public MovingAverage(int windowSize) {
            index = 0;
            this.windowSize = windowSize;
            cache = new int[windowSize];
        }

        public double next(int i) {
            size = size < windowSize ? size + 1 : size;
            currentTotal += i;
            currentTotal -= cache[index];
            cache[index] = i;
            double result = ((double) currentTotal / (double) size);
            index = (index + 1) % windowSize;
            return result;
        }
    }

}
