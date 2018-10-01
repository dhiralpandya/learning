package com.omt.learn.geekforgeek.dynamic;

public class MinEditStringDynamic {

    public static void main(String... args) {

        String p = "AYZ";
        String q = "AXYZ";


        System.out.println("Min edit " + minEditRequire(p, q) + " required to make " + p + " like " + q + " ");


        p = "CAT";
        q = "CUT";


        System.out.println("Min edit " + minEditRequire(p, q) + " required to make " + p + " like " + q + " ");


        p = "SUNDAY";
        q = "SATURDAY";


        System.out.println("Min edit " + minEditRequire(p, q) + " required to make " + p + " like " + q + " ");

    }

    public static int minEditRequire(String p, String q) {

        int[][] matrix = new int[p.length() + 1][q.length() + 1];

        //Initial setup of row
        for (int i = 0; i < p.length() + 1; i++) {
            matrix[i][0] = i;
        }

        //Initial setup of column
        for (int i = 0; i < q.length() + 1; i++) {
            matrix[0][i] = i;
        }

        for (int i = 1; i < p.length() + 1; i++) {
            for (int j = 1; j < q.length() + 1; j++) {
                if (p.charAt(i - 1) == q.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    int min = 1 + Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1]));
                    matrix[i][j] = min;
                }
            }
        }

        return matrix[p.length()][q.length()];
    }

}
