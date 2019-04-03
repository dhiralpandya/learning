package com.omt.learn.leetcode.google;

import java.util.Set;
import java.util.TreeSet;

public class NextClosestTime681 {


    static Set<Integer> allValidH1Digit = new TreeSet<Integer>() {
        {
            add(0);
            add(1);
            add(2);
        }
    };

    static Set<Integer> allValidH2Digit = new TreeSet<Integer>() {
        {
            add(0);
            add(1);
            add(2);
            add(3);
            add(4);
        }
    };

    static Set<Integer> allValidM1Digit = new TreeSet<Integer>() {
        {
            add(0);
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }
    };

    static Set<Integer> allValidM2Digit = new TreeSet<Integer>() {
        {
            add(0);
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(9);
        }
    };

    public static void main(String args[]) {
        System.out.println(nextClosestTime("23:23"));
        System.out.println(nextClosestTime("23:59"));
        System.out.println(nextClosestTime("19:34"));

        System.out.println(nextClosestTime2("23:23"));
        System.out.println(nextClosestTime2("23:59"));
        System.out.println(nextClosestTime2("19:34"));

    }


    public static String nextClosestTime(String time) {

        Set<Integer> allAvailableDigit = new TreeSet<>();
        for (char c : time.toCharArray()) {
            allAvailableDigit.add(Character.getNumericValue(c));
        }

        int m2 = Character.getNumericValue(time.charAt(4));
        int m1 = Character.getNumericValue(time.charAt(3));
        int h2 = Character.getNumericValue(time.charAt(1));
        int h1 = Character.getNumericValue(time.charAt(0));

        int temp = m2;
        while (allValidM2Digit.contains(temp + 1)) {
            if (allAvailableDigit.contains(temp + 1)) {
                return h1 + "" + h2 + ":" + m1 + "" + (temp + 1);
            }
            temp++;
        }

        temp = m1;
        while (allValidM1Digit.contains(temp + 1)) {
            if (allAvailableDigit.contains(temp + 1)) {
                String result = h1 + "" + h2 + ":" + (temp + 1);
                int tempM2 = m2;
                while (allValidM2Digit.contains(tempM2 - 1)) {
                    if (allAvailableDigit.contains(tempM2 - 1)) {
                        m2 = tempM2 - 1;
                    }
                    tempM2--;
                }
                return result + m2;
            }

            temp++;
        }

        temp = h2;
        while (allValidH2Digit.contains(temp + 1)) {
            if (allAvailableDigit.contains(temp + 1)) {
                String result = h1 + "" + h2 + ":";

                int tempM1 = m1;
                while (allValidM1Digit.contains(tempM1 - 1)) {
                    if (allAvailableDigit.contains(tempM1 - 1)) {
                        m1 = tempM1 - 1;
                    }
                    tempM1--;
                }

                result += "" + m1;

                int tempM2 = m2;
                while (allValidM2Digit.contains(tempM2 - 1)) {
                    if (allAvailableDigit.contains(tempM2 - 1)) {
                        m2 = tempM2 - 1;
                    }
                    tempM2--;
                }
                return result + m2;

            }
            temp++;
        }

        return h1 + "" + h1 + ":" + h1 + "" + h1;
    }


    public static String nextClosestTime2(String time) {
        int hh = Integer.parseInt(time.substring(0, 2));
        int mm = Integer.parseInt(time.substring(3));
        int timeInMin = hh * 60 + mm;

        Set<Integer> allAvailableDigit = new TreeSet<>();
        for (char c : time.toCharArray()) {
            allAvailableDigit.add(Character.getNumericValue(c));
        }

        int totalMinIn24Hr = 60 * 24;

        int nextClosestTimeInMin = timeInMin + 1;
        while (nextClosestTimeInMin != timeInMin) {
            nextClosestTimeInMin = nextClosestTimeInMin % totalMinIn24Hr;

            int h1h2 = nextClosestTimeInMin / 60;
            int m1m2 = nextClosestTimeInMin % 60;
            int h1 = h1h2 / 10;
            int h2 = h1h2 % 10;
            int m1 = m1m2 / 10;
            int m2 = m1m2 % 10;

            if (allAvailableDigit.contains(h1)
                    && allAvailableDigit.contains(h2)
                    && allAvailableDigit.contains(m1)
                    && allAvailableDigit.contains(m2)) {
                return h1 + "" + h2 + ":" + m1 + "" + m2;
            }

            nextClosestTimeInMin++;
        }

        return null;
    }


}


