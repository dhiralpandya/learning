package com.omt.learn.leetcode.google;

import java.util.Stack;

/**
 * 394. Decode String
 * <p>
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid;
 * No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and
 * that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * s = "2[abc]b10[cd5[d]]ef", return "".
 */
public class DecodeString394 {

    public static void main(String args[]) {

        System.out.println(decode("2[abc]3[cd]ef"));
        System.out.println(decode("2[ab3[c]d]"));
        System.out.println(decode("3[a]2[bc]"));
        System.out.println(decode("2[abc]b2[cd3[v]]ef"));
    }

    public static String decode(String input) {


        Stack<String> stringStack = new Stack<>();

        int totalSizeOfInputString = input.length();

        for (int count = 0; count < input.length(); count++) {

            StringBuilder numberString = new StringBuilder();
            while (count < totalSizeOfInputString && Character.isDigit(input.charAt(count))) {
                numberString.append(input.charAt(count));
                count++;
            }

            if (numberString.length() > 0) {
                stringStack.push(numberString.toString());
            }

            if (input.charAt(count) == '[') {
                stringStack.push(""); // STEP NUMBER 1 >> WE are doing this for STEP NUMBER 2
            } else if (input.charAt(count) == ']') {
                StringBuilder sb = new StringBuilder();

                String append = stringStack.pop();
                int repetitionCount = Integer.valueOf(stringStack.pop());

                while (repetitionCount > 0) {
                    sb.append(append);
                    repetitionCount--;
                }

                if (stringStack.isEmpty()) {
                    stringStack.push(sb.toString());
                } else {
                    stringStack.push(stringStack.pop() + sb.toString());
                }

            } else {
                stringStack.push(stringStack.pop() + String.valueOf(input.charAt(count))); //STEP NUMBER 2
            }


        }


        return stringStack.pop();
    }

}
