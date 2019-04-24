package com.omt.learn.leetcode.google;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges163 {

    public static void main(String args[]) {
        int range1[] = {0, 1, 3, 50, 75};
        missingRanges(range1, 0, 99).forEach(s -> System.out.print(s + ","));
    }


    public static List<String> missingRanges(int[] range, int low, int high) {
        List<String> missingRanges = new ArrayList<>();

        int current = low;
        for (int index = 0; index < range.length; index++) {

            if (range[index] > current) {

                int previous = range[index] - 1;
                int next = range[index] - 1;

                if (index > 0) {
                    previous = range[index - 1] + 1;
                }

                if (previous == next) {
                    missingRanges.add(next + "");
                } else {
                    missingRanges.add(previous + "->" + next);
                }
                
                current = range[index];
            }

            current++;
        }


        if (high > current - 1) {
            if (current == high) {
                missingRanges.add("" + high);
            } else {
                missingRanges.add(current + "->" + high);
            }
        }

        return missingRanges;
    }

}
