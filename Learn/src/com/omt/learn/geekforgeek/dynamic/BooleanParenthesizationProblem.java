package com.omt.learn.geekforgeek.dynamic;

public class BooleanParenthesizationProblem {

    //Find these images to understand the algo 
    //https://github.com/dhiralpandya/learning/commit/49eb0d35e91c8baf8417c2608c917a725fcb6647
    public static void main(String args[]) {
        boolean symbol[] = {true, false, true};
        char op[] = {'^', '&'};
        System.out.println(findCount(symbol, op));


        boolean symbol2[] = {true, true, false, true};
        char op2[] = {'|', '&', '^'};
        System.out.println(findCount(symbol2, op2));


    }

    //Get more idea of algo by looking these images 
    //https://github.com/dhiralpandya/learning/commit/49eb0d35e91c8baf8417c2608c917a725fcb6647
    public static int findCount(boolean symbol[], char op[]) {

        boolean result[][] = new boolean[symbol.length][symbol.length];
        int count = 0;

        for (int index = 0; index < symbol.length; index++) {
            result[index][index] = symbol[index];
        }

        for (int length = 2; length < symbol.length; length++) {
            for (int i = 0; (i + length - 1) < symbol.length; i++) {
                int start = i;
                int end = length - 1 + i;
                boolean isStartGretterZero = start > 0;
                boolean isEndSmallerThanLength = end < symbol.length - 1;
                boolean zeroToStart = false;
                boolean startToLength = false;
                boolean lengthToEnd = false;


                startToLength = fromTo(start, end, symbol, op);

                if (isStartGretterZero) {
                    zeroToStart = fromTo(0, start - 1, symbol, op);
                    startToLength = op(zeroToStart, startToLength, op[start - 1]);
                }

                if (isEndSmallerThanLength) {

                    lengthToEnd = fromTo(end + 1, symbol.length - 1, symbol, op);
                    startToLength = op(startToLength, lengthToEnd, op[end]);
                }

                if (startToLength) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean fromTo(int from, int to, boolean symbol[], char op[]) {
        if (from == to) {
            return symbol[from];
        }

        boolean left = op(symbol[from], symbol[from + 1], op[from]);
        for (int start = from + 2; start <= to; start = start + 2) {
            boolean right = false;
            if (start == to) {
                right = symbol[start];
            } else {
                right = op(symbol[start], symbol[start + 1], op[start]);
            }
            left = op(left, right, op[start - 1]);

        }

        return left;
    }

    public static boolean op(boolean left, boolean right, char op) {
        if (op == '|') {
            return left | right;
        } else if (op == '&') {
            return left & right;
        } else if (op == '^') {
            return left ^ right;
        }
        return false;
    }

}
