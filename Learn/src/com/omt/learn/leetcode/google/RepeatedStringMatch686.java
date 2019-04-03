package com.omt.learn.leetcode.google;

public class RepeatedStringMatch686 {

    public static void main(String args[]) {
        System.out.println(match("pc", "cp"));
        System.out.println(match("abcd", "cdabcdab"));
        System.out.println(match("a", "aa"));


    }

    public static int match(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        if (sb.indexOf(b) >= 0) return count;
        if (sb.append(a).indexOf(b) >= 0) return count + 1;
        return -1;
    }
}
