package com.omt.learn.leetcode.google;

import java.util.Set;
import java.util.TreeSet;

public class UniqueWordAbbreviation288 {

    public static void main(String args[]) {
        String[] dir = {"deer", "door", "cake", "card", "s"};
        System.out.println(isUnique(dir, "dear"));
        System.out.println(isUnique(dir, "cart"));
        System.out.println(isUnique(dir, "cane"));
        System.out.println(isUnique(dir, "make"));
        System.out.println(isUnique(dir, "ss"));
        System.out.println(isUnique(dir, "s"));
    }


    public static boolean isUnique(String[] dir, String word) {

        String wordKey = word.length() < 2 ? word :
                String.valueOf(word.charAt(0)) + (word.length() - 2) + String.valueOf(word.charAt(word.length() - 1));

        Set<String> dirSet = new TreeSet<>();

        for (String s : dir) {
            String key = s.length() < 2 ? s :
                    String.valueOf(s.charAt(0)) + (s.length() - 2) + String.valueOf(s.charAt(s.length() - 1));
            dirSet.add(key);
        }

        return !dirSet.contains(wordKey);
    }


}
