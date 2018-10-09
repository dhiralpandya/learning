package com.omt.learn.geekforgeek.dynamic;

import com.omt.learn.algo.util.matrix.MatrixUtil;

public class PalindromePartitioning {

    public static void main(String args[]) {
        String s = "banana";
        System.out.println(minPartition(s));

        s = "ababbbabbababa";
        System.out.println(minPartition(s));
    }

    public static int minPartition(String s) {
        int result[][] = new int[s.length()][s.length()];

        for (int oneChar = 0; oneChar < s.length(); oneChar++) {
            result[oneChar][oneChar] = 0;
        }

        for (int stringLength = 1; stringLength < s.length(); stringLength++) {

            for (int firstChar = 0; firstChar + stringLength < s.length(); firstChar++) {
                int lastChar = firstChar + stringLength;
                int row = firstChar;
                int column = lastChar;

                if (s.charAt(firstChar) == s.charAt(lastChar) && result[row + 1][column - 1] == 0) {
                    result[row][column] = 0;
                } else {
                    result[row][column] = 1 + Math.min(result[row][column - 1], result[row + 1][column]);
                }
            }

        }
        System.out.println("------------------");
        MatrixUtil.printMatrix(result);
        System.out.println("------------------");
        return result[0][s.length() - 1];
    }

}
