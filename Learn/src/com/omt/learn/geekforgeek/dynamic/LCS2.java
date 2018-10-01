package com.omt.learn.geekforgeek.dynamic;

public class LCS2 {


    public static void main(String... args) {

        String p = "AXYZ";
        String q = "AYZ";
        System.out.println("LCS is :" + LCS(p, q));

        p = "AGGTAB";
        q = "GXTXAYB";
        System.out.println("LCS is :" + LCS(p, q));


    }


    public static int LCS(String p, String q) {
        int[][] lcs = new int[p.length()][q.length()];

        for (int column = 0; column < q.length(); column++) {
            if (p.charAt(0) == q.charAt(column)) {
                lcs[0][column] = 1;
            } else {
                if (column == 0) {
                    lcs[0][column] = 0;
                } else {
                    lcs[0][column] = lcs[0][column - 1];
                }
            }
        }
        printMatrix(lcs);

        for (int i = 1; i < p.length(); i++) {
            for (int j = 0; j < q.length(); j++) {
                if (p.charAt(i) == q.charAt(j)) {
                    if (j == 0) {
                        lcs[i][j] = 1;
                    } else {
                        lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    }
                } else {
                    if (j == 0) {
                        lcs[i][j] = lcs[i - 1][j];
                    } else {
                        lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                    }
                }
            }
        }
        printMatrix(lcs);
        return lcs[p.length() - 1][q.length() - 1];
    }


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

}
