package com.omt.learn.leetcode.google;

import com.omt.learn.algo.util.matrix.MatrixUtil;

public class GameOfLife289 {


    public static void main(String args[]) {
        int[][] life = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        updateGameOfLife(life);
        MatrixUtil.printMatrix(life);
    }

    public static void updateGameOfLife(int[][] life) {

        int[][] directions = {
                {-1, -1}, {0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}
        };


        int endgame[][] = new int[life.length][life[0].length];

        int maxR = life.length;
        int maxCol = life[0].length;

        for (int row = 0; row < life.length; row++) {
            for (int column = 0; column < life[row].length; column++) {

                int neighbourCount = 0;
                for (int[] direction : directions) {
                    int r = row + direction[0];
                    int c = column + direction[1];
                    if (isValidDirection(maxR, maxCol, r, c) && life[r][c] == 1) {
                        neighbourCount++;
                    }
                }

                endgame[row][column] = gameRule(neighbourCount, life[row][column]);

            }
        }


        for (int row = 0; row < life.length; row++) {
            for (int column = 0; column < life[row].length; column++) {
                life[row][column] = endgame[row][column];
            }
        }

    }


    public static int gameRule(int neighboursCount, int currentStatus) {
        if (neighboursCount < 2) {
            return 0;
        } else if ((neighboursCount == 2 || neighboursCount == 3) && currentStatus == 1) {
            return currentStatus;
        } else if (neighboursCount > 3) {
            return 0;
        } else if (currentStatus == 0 && neighboursCount == 3) {
            return 1;
        }

        return 0;
    }


    public static boolean isValidDirection(int maxRow, int maxColumn, int currentRow, int currentColumn) {
        if (currentColumn >= maxColumn || currentRow >= maxRow || currentColumn < 0 || currentRow < 0) {
            return false;
        }

        return true;
    }

}
