package com.omt.learn.geekforgeek.dynamic;

import java.util.ArrayList;
import java.util.List;

public class MaxLengthChainOfPairs {

    static class Pair {

        int a;
        int b;

        public Pair(int a, int b) {

            this.a = a;
            this.b = b;
        }

    }

    public static void main(String args[]) {

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(5, 24));
        pairs.add(new Pair(15, 25));
        pairs.add(new Pair(27, 40));
        pairs.add(new Pair(50, 60));

        System.out.println(getMaxLength(pairs));

    }

    public static int getMaxLength(List<Pair> pairs) {
        int maxLength = 0;

        int result[] = new int[pairs.size()];

        result[0] = 1;

        for (int i = 1; i < pairs.size(); i++) {
            if (pairs.get(i - 1).b < pairs.get(i).a) {
                result[i] = 1 + result[i - 1];
            } else {
                result[i] = 1;
            }
            maxLength = Math.max(maxLength, result[i]);
        }

        return maxLength;
    }
}
