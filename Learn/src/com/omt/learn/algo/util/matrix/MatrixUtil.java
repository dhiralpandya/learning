package com.omt.learn.algo.util.matrix;

public class MatrixUtil {
    public static void printMatrix(int[][] i) {
        for (int[] p : i) {
            for (int px : p) {
                if (px > 9) {
                    System.out.print(px + " ");
                } else {
                    System.out.print(px + "  ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] createMatrix(int m, int n) {
        int[][] matrix = new int[m][n];


        int count = 1;
        for (int raw = 0; raw < m; raw++) {

            for (int column = 0; column < n; column++) {
                matrix[raw][column] = count++;
            }

        }


        return matrix;
    }

}
