package com.omt.learn.leetcode.google;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings271 {


    public static void main(String args[]) {


        String encode10 = encodeGood(Lists.newArrayList("omt", "abc", "def", "xyz"));
        System.out.println();
        System.out.println(encode10);
        List<String> decode10 = decodeGood(encode10);
        System.out.println();
        System.out.println(Arrays.toString(decode10.toArray()));


        String encode20 = encodeGood(Lists.newArrayList("|omt|", "/|abc|", "|def", "|xyz/", "|", "/|", "/"));
        System.out.println();
        System.out.println(encode20);
        List<String> decode20 = decodeGood(encode20);
        System.out.println();
        System.out.println(Arrays.toString(decode20.toArray()));


        String encode30 = encodeGood(Lists.newArrayList("12,10,5,5,5<>|omt|", "<>/|abc|", "|def", "|xyz/", "<>|<>",
                "<>/|<>",
                "<>/<>"));
        System.out.println();
        System.out.println(encode30);
        List<String> decode30 = decodeGood(encode30);
        System.out.println();
        System.out.println(Arrays.toString(decode30.toArray()));

//        String encode1 = encode(Lists.newArrayList("omt", "abc", "def", "xyz"));
//        System.out.println();
//        System.out.println(encode1);
//        List<String> decode1 = decode(encode1);
//        System.out.println();
//        System.out.println(Arrays.toString(decode1.toArray()));
//
//
//        String encode2 = encode(Lists.newArrayList("|omt|", "/|abc|", "|def", "|xyz/", "|", "/|", "/"));
//        System.out.println();
//        System.out.println(encode2);
//        List<String> decode2 = decode(encode2);
//        System.out.println();
//        System.out.println(Arrays.toString(decode2.toArray()));


    }


    public static String encode(List<String> strings) {

        char ENCODE_CHAR = '|';
        char IGNORE_CHAR = '/';

        StringBuilder sb = new StringBuilder();


        for (int count = 0; count < strings.size(); count++) {

            for (char c : strings.get(count).toCharArray()) {
                if (c == ENCODE_CHAR) {
                    sb.append(IGNORE_CHAR);
                }

                sb.append(c);
            }

            if (count != strings.size() - 1) {
                sb.append(ENCODE_CHAR);
            }

        }

        return sb.toString();
    }


    public static List<String> decode(String s) {


        char ENCODE_CHAR = '|';
        char IGNORE_CHAR = '/';

        List<String> result = Lists.newArrayList();

        StringBuilder runningString = new StringBuilder();

        for (int count = 0; count < s.length(); count++) {
            if (s.charAt(count) == IGNORE_CHAR && count != s.length() - 1 && s.charAt(count + 1) == ENCODE_CHAR) {
                runningString.append(s.charAt(count + 1));
                count++;
            } else if (s.charAt(count) == ENCODE_CHAR) {
                result.add(runningString.toString());
                runningString.setLength(0);//clearing the StringBuilder
            } else {
                runningString.append(s.charAt(count));
            }

        }

        if (runningString.length() > 0) {
            result.add(runningString.toString());
        }
        return result;
    }


    public static String encodeGood(List<String> strings) {
        StringBuilder counts = new StringBuilder();
        StringBuilder sb = new StringBuilder();


        for (int count = 0; count < strings.size(); count++) {

            String s = strings.get(count);
            counts.append(s.length());
            sb.append(s);


            if (count != strings.size() - 1) {
                counts.append(",");
            }
        }

        counts.append("<>");
        return counts.append(sb).toString();
    }

    public static List<String> decodeGood(String s) {
        List<String> result = Lists.newArrayList();

        int firstIndex = s.indexOf("<>");

        String[] counts = s.substring(0, firstIndex).split(",");
        String encode = s.substring(firstIndex + "<>".length());

        int previousCount = 0;
        for (String count : counts) {
            result.add(encode.substring(previousCount, previousCount + Integer.parseInt(count)));
            previousCount += Integer.parseInt(count);
        }

        return result;
    }

}
