package com.omt.learn.leetcode.google;

public class LicenseKeyFormatting482 {

    public static void main(String args[]) {
        System.out.println(format("5F3Z-2e-9-w", 4));
        System.out.println(format("2-5g-3-J", 2));
    }


    public static String format(String s, int k) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int collectedChars = 0;
        int dashAddedCount = 0;
        for (int count = 0; count < length; count++) {

            if (s.charAt(count) != '-') {
                sb.append(Character.toUpperCase(s.charAt(count)));
                collectedChars++;
            } else if (dashAddedCount == 0) {
                dashAddedCount++;
                collectedChars = 0;
                sb.append("-");
            }

            if (collectedChars == k && count != length - 1) {
                dashAddedCount++;
                collectedChars = 0;
                sb.append("-");
            }

        }

        return sb.toString();
    }

}
