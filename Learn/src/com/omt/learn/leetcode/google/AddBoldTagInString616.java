package com.omt.learn.leetcode.google;

import com.google.common.collect.Sets;

import java.util.LinkedList;
import java.util.Set;

public class AddBoldTagInString616 {

    public static void main(String args[]) {
        String s = "abcxyz123";
        String[] dict = {"abc", "123"};
        Set<String> set1 = Sets.newTreeSet();
        set1.add("abc");
        set1.add("123");

        System.out.println(Solution1.addBoldTags(s, dict));
        System.out.println(Solution2.addBoldTags(s, set1));

        String s1 = "aaabbcc";
        String[] dict1 = {"aaa", "aab", "bc"};

        Set<String> set2 = Sets.newTreeSet();
        set2.add("aaa");
        set2.add("aab");
        set2.add("bc");


        System.out.println(Solution1.addBoldTags(s1, dict1));
        System.out.println(Solution2.addBoldTags(s1, set2));

    }


    static class Solution2 {
        public static String addBoldTags(String s, Set<String> dict) {
            LinkedList<Integer> startIndex = new LinkedList<>();
            LinkedList<Integer> endIndex = new LinkedList<>();

            for (int start = 0; start < s.length(); start++) {
                for (int end = start; end <= s.length(); end++) {//IMP Step where end <=s.length();
                    String word = s.substring(start, end);
                    if (dict.contains(word)) {

                        if (startIndex.isEmpty()) {
                            startIndex.add(start);
                            endIndex.add(end - 1); // IMP
                        } else {
                            if (start < endIndex.getLast() || start == endIndex.getLast() + 1) {

                                if (end - 1 > endIndex.getLast()) {// IMP
                                    endIndex.removeLast();
                                    endIndex.add(end - 1);// IMP
                                }

                            } else {
                                startIndex.add(start);
                                endIndex.add(end - 1); // IMP
                            }
                        }

                    }
                }
            }


            StringBuilder sb = new StringBuilder();


            for (int i = 0; i < s.length(); i++) {
                if (!startIndex.isEmpty() && i == startIndex.peek()) {
                    startIndex.pop();
                    sb.append("<b>");
                }
                sb.append(s.charAt(i));
                if (!endIndex.isEmpty() && i == endIndex.peek()) {
                    endIndex.pop();
                    sb.append("</b>");
                }
            }

            return sb.toString();
        }
    }


    static class Solution1 {


        public static String addBoldTags(String s, String[] dict) {
            StringBuilder sb = new StringBuilder();


            boolean isChartAtInBOLD[] = new boolean[s.length()];
            int endIndex = 0;
            for (int startIndex = 0; startIndex < s.length(); startIndex++) {
                for (String word : dict) {
                    if (s.startsWith(word, startIndex)) {
                        endIndex = Math.max(endIndex, startIndex + word.length());
                    }
                }
                isChartAtInBOLD[startIndex] = endIndex > startIndex;
            }

            for (int i = 0; i < s.length(); i++) {
                if (!isChartAtInBOLD[i]) {
                    sb.append(s.charAt(i));
                    continue;
                }

                int j = i;
                while (j < s.length() && isChartAtInBOLD[j]) {
                    j++;
                }

                sb.append("<b>" + s.substring(i, j) + "</b>");
                i = j - 1;//Because i++ will be there above.

            }

            return sb.toString();
        }


    }

}
