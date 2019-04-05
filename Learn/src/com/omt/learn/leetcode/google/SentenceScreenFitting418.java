package com.omt.learn.leetcode.google;

public class SentenceScreenFitting418 {

    public static void main(String args[]) {
        String words[] = {"I", "had", "apple", "pie"};
        System.out.println(fittingCount(4, 5, words));

        String words2[] = {"hello", "world"};
        System.out.println(fittingCount(2, 8, words2));

        String words3[] = {"a", "bcd", "e"};
        System.out.println(fittingCount(3, 6, words3));

    }

    public static int fittingCount(int row, int column, String[] words) {
        int rowCount = row;
        int columnCount = column;

        int fittingCount = 0;

        while (rowCount > 0) {

            int index;
            for (index = 0; index < words.length && rowCount > 0; index++) {
                String word = words[index];
                if (word.length() > column) {
                    rowCount = -1;
                    break;
                } else if (word.length() < columnCount) {
                    columnCount -= (word.length() + 1);
                } else {
                    rowCount--;
                    columnCount = column - word.length() - 1;
                }
            }

            if (index == words.length) {
                fittingCount++;
            }

        }

        return fittingCount;

    }

}
