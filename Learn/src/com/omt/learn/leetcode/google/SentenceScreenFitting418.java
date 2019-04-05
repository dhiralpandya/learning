package com.omt.learn.leetcode.google;

/**
 * Description
 * 中文
 * English
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given 
 * sentence can be fitted on the screen.
 *
 * A word cannot be split into two lines.
 * The order of words in the sentence must remain unchanged.
 * Two consecutive words in a line must be separated by a single space.
 * Total words in the sentence won't exceed 100.
 * Length of each word is greater than 0 and won't exceed 10.
 * 1 ≤ rows, cols ≤ 20,000.
 * Have you met this question in a real interview?  
 * Example
 * Example 1:
 * 	Input: rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
 * 	Output: 1
 *
 * 	Explanation:
 * 	I-had
 * 	apple
 * 	pie-I
 * 	had--
 *
 * 	The character '-' signifies an empty space on the screen.
 *
 * Example 2:
 * 	Input:  rows = 2, cols = 8, sentence = ["hello", "world"]
 * 	Output:  1
 *
 * 	Explanation:
 *
 * 	hello---
 * 	world---
 *
 * 	The character '-' signifies an empty space on the screen.
 *
 * Example 3:
 * 	Input: rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
 * 	Output:  2
 *
 * 	Explanation:
 * 	a-bcd-
 * 	e-a---
 * 	bcd-e-
 *
 * 	The character '-' signifies an empty space on the screen.
 */
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
