package com.omt.learn.leetcode.google;

public class BombEnemy361 {

    public static void main(String args[]) {

        char input1[][] = {
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        };

        System.out.println(maxCount(input1));

    }

    public static int maxCount(char input[][]) {

        Data result[][] = new Data[input.length][input[0].length];

        Data maxCount = new Data();

        for (int row = 0; row < input.length; row++) {

            for (int column = 0; column < input[row].length; column++) {


                //CHECK WALL CONDITION -------------------|
                if (input[row][column] == 'W') {
                    Data wall = new Data();
                    wall.isWall = true;
                    result[row][column] = wall;
                    continue;
                }
                //-------------------|


                Data data = new Data();
                data.row = row;
                data.column = column;
                data.isEnemy = input[row][column] == 'E';

                //IDENTIFY ROW COUNT -------------------------|
                //SEARCH EVERYTHING TO THE END IF ROW IS ZERO OR PREVIOUS WAS WALL
                if (row == 0 || result[row - 1][column].isWall) {

//                    if (data.isEnemy) {
//                        data.rCount++;
//                    }
                    //for (int index = row+1; index < input.length; index++) {

                    for (int index = row; index < input.length; index++) {
                        if (input[index][column] == 'E') {
                            data.rCount++;
                        } else if (input[index][column] == 'W') {
                            break;
                        }
                    }
                } else { // TAKE IS FROM PREVIOUS COUNT
                    data.rCount = result[row - 1][column].rCount;
                }
                //-------------------------|


                //IDENTIFY COLUMN COUNT ------------------------|
                //SEARCH EVERYTHING TO THE END IF COLUMN IS ZERO OR PREVIOUS WAS WALL
                if (column == 0 || result[row][column - 1].isWall) {

                    for (int index = column; index < input[row].length; index++) {
                        if (input[row][index] == 'E') {
                            data.cCount++;
                        } else if (input[row][index] == 'W') {
                            break;
                        }
                    }

                } else {// TAKE IS FROM PREVIOUS COUNT
                    data.cCount = result[row][column - 1].cCount;
                }
                //------------------------|

                result[row][column] = data;

                if (data.isBlankSpace() && data.getCount() > maxCount.getCount()) {
                    maxCount = data;
                }

            }

        }
        System.out.println("Position is : [ROW(" + maxCount.row + "),COLUMN(" + maxCount.column + ")]");
        return maxCount.getCount();
    }


    static class Data {
        int rCount = 0;
        int cCount = 0;
        int row;
        int column;
        boolean isEnemy = false;
        boolean isWall = false;

        public boolean isBlankSpace() {
            return !isEnemy && !isWall;
        }

        public int getCount() {
            return rCount + cCount;
        }
    }
}
