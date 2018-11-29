package com.omt.learn.geekforgeek.dynamic;

import com.omt.learn.algo.util.matrix.MatrixUtil;

public class MinInitialPoint {

    public static void main(String args[]) {
        int points[][] = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };

        System.out.println(minInitialPoint(points));
    }

    /**
     * We will start with matrix[length][length],
     * Bottom-Up and create one more matrix to store min initial point at each stage.
     * formula is : matrix_cache[row][column] = Math.max{minPoint-matrix[row][column],1}
     * Since we are doing bottom up, We will calculate DOWN and RIGHT to find minPoint at each stage.
     *
     * @param points
     * @return
     */
    private static int minInitialPoint(int points[][]) {
        int minInitialPoint = 0;

        int cache[][] = new int[points.length][points[0].length];


        int lastRow = points.length - 1;
        int lastColumn = points[0].length - 1;

        cache[lastRow][lastColumn] = Math.max(0 - points[lastRow][lastColumn], 1);
        //Calculate Last Row
        for (int column = lastColumn - 1; column >= 0; column--) {
            int previousMinCost = cache[lastRow][column + 1];
            cache[lastRow][column] = Math.max(previousMinCost - points[lastRow][column], 1);
        }

        //Calculate Last Column
        for (int row = lastRow - 1; row >= 0; row--) {
            int previousMinCost = cache[row + 1][lastColumn];
            cache[row][lastColumn] = Math.max(previousMinCost - points[row][lastColumn], 1);

        }


        //Bottom-Up : Moving LEFT AND UP by comparing RIGHT AND DOWN.
        for (int row = lastRow - 1; row >= 0; row--) {
            for (int column = lastColumn - 1; column >= 0; column--) {

                int currentPoint = points[row][column];

                int minDOWNCost = cache[row + 1][column];
                int minRIGHTCost = cache[row][column + 1];
                int minPreviousCost = Math.min(minDOWNCost, minRIGHTCost);

                cache[row][column] = Math.max(minPreviousCost - currentPoint, 1);
            }
        }

        MatrixUtil.printMatrix(cache);
        minInitialPoint = cache[0][0] + 1;
        return minInitialPoint;
    }
}
