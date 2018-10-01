package com.omt.learn.geekforgeek.dynamic;

public class MinCostPathDynamic {

    public static void main(String... args) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};

        System.out.println("Min Cost:" + minCost(cost, 0, 0, 2, 2));

    }

    public static int minCost(int[][] cost, int i, int j, int di, int dj) {

        int[][] matrix = new int[cost.length][cost.length];

        matrix[0][0] = cost[0][0];
        //Setup First row
        for (int row = 1; row < cost.length; row++) {
            matrix[row][0] = matrix[row - 1][0] + cost[row][0];
        }

        //Setup First Column
        for (int column = 1; column < cost[0].length; column++) {
            matrix[0][column] = matrix[0][column - 1] + cost[0][column];
        }

        //Setup I and J
        i = i == 0 ? 1 : i;
        j = j == 0 ? 1 : j;

        for (int row = i; row <= di; row++) {
            for (int column = j; column <= dj; column++) {
                int min = Math.min(matrix[row - 1][column - 1], Math.min(matrix[row - 1][column], matrix[row][column - 1]));
                matrix[row][column] = min + cost[row][column];
            }
        }

        return matrix[di][dj];
    }

}
