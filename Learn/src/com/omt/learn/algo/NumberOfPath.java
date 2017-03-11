package com.omt.learn.algo;

public class NumberOfPath {

    public static void main(String[] args) throws Exception {

        int a[][] = new int[][]{
                {
                        1, 1, 1, 1
                },
                {
                        0, 1, 0, 1
                },
                {
                        0, 1, 1, 0
                },
                {
                        1, 1, 1, 1
                }
        };
        System.out.println(numberOfPaths(a));
    }

    private static int numberOfPaths(int[][] a) {

        int m = a.length;
        int n = a[0].length;

        return numberOfPaths(a, 0, 0, m, n);
    }

    private static int numberOfPaths(int[][] a, int i, int j, int m, int n) {

        if (i < m && j < n) {

            if (a[i][j] == 1) {
                if (i == m - 1 && j == n - 1) {
                    return 1;
                } else {
                    return numberOfPaths(a, i, j + 1, m, n) + numberOfPaths(a, i + 1, j, m, n);
                }
            } else {
                return 0;
            }
        }
        return 0;

    }

}
