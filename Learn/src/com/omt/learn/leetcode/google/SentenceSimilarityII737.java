package com.omt.learn.leetcode.google;

import java.util.Map;
import java.util.TreeMap;

/**
 * 737. Sentence Similarity II
 * <p>
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs
 * pairs, determine if two sentences are similar.
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar,
 * if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
 * Note that the similarity relation is transitive.
 * <p>
 * For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are
 * similar.
 * Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great"
 * being similar.
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"],
 * pairs = [] are similar, even though there are no specified similar word pairs.
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 =
 * ["great"] can never be similar to words2 = ["doubleplus","good"].
 * Note:
 * The length of words1 and words2 will not exceed 1000.
 * The length of pairs will not exceed 2000.
 * The length of each pairs[i] will be 2.
 * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */

public class SentenceSimilarityII737 {

    public static void main(String args[]) {

    }

    public static boolean isBothAreSame(String[] word1, String[] word2, String[][] pairs) {

        Map<String, String> pairMap = prepareMap(pairs);

        if (word1.length != word2.length) {
            return false;
        }

        for (int count = 0; count < word1.length; count++) {
            if (word1[count].equals(word2[count])
                    || getParent(pairMap, word1[count]).equals(getParent(pairMap, word2[count]))) {
                continue;
            } else {
                System.out.println(word1[count] + " : " + word2[count] + " count:" + count);
                return false;
            }
        }

        return true;
    }


    public static String getParent(Map<String, String> pairMap, String key) {
        String result = key;

        while (pairMap.get(result) != null && !result.equals(pairMap.get(result))) {
            result = pairMap.get(result);
        }

        return result;
    }

    public static Map<String, String> prepareMap(String[][] pairs) {
        Map<String, String> map = new TreeMap<>();

        for (String[] pair : pairs) {
            String one = pair[0];
            String two = pair[1];

            if (!map.containsKey(one)) {
                map.put(one, one);
            }

            if (!map.containsKey(two)) {
                map.put(two, two);
            }

            map.put(getParent(map, one), getParent(map, two));

        }

        return map;
    }


}
