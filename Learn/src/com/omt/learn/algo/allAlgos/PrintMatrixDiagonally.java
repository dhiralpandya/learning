package com.omt.learn.algo.allAlgos;

import com.omt.learn.algo.util.matrix.MatrixUtil;

/**
 * Created by omt on 4/8/17.
 */
public class PrintMatrixDiagonally {

    public static void main(String... args) {

        int a[][] = MatrixUtil.createMatrix(4, 4);
        MatrixUtil.printMatrix(a);
        printMatrixDiagonally(a);
    }


    public static void printMatrixDiagonally(int matrix[][]) {

        StringBuilder sb = new StringBuilder();

        StringBuilder sb3 = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            StringBuilder sb2 = new StringBuilder();
            int index = row;
            int lastRow = matrix.length - 1;
            int lastColumn = matrix[row].length - 1 - row;
            for (int column = 0; (row - column >= 0); column++) {
                sb.append(matrix[index][column]);
                sb.append(" ");

                if (lastColumn > 0 && (lastColumn + column) < matrix[row].length) {
                    sb2.append(matrix[lastRow][lastColumn + column]);
                    sb2.append(" ");
                    lastRow--;
                }

                index--;
            }
            if (sb2.length() > 0) {
                sb2.append("\n");
            }
            sb3.insert(0, sb2.toString());
            sb.append("\n");

        }

        System.out.print(sb.toString());
        System.out.println(sb3.toString());
    }

}
