package com.omt.learn.leetcode.google;

/**
 * The problem statement provides 2 different examples for you to understand the rules to define a valid UTF-8
 * charset. That might not be enough for a lot of people and so the first thing we would do is try to understand all
 * the rules given in the problem statement and in the meantime look at a few examples in detail that will help
 * clarify the problem. Here are the rules in the question statement:
 * <p>
 * A valid UTF-8 character can be 1 - 4 bytes long.
 * For a 1-byte character, the first bit is a 0, followed by its unicode.
 * For an n-bytes character, the first n-bits are all ones, the n+1 bit is 0, followed by n-1 bytes with most
 * significant 2 bits being 10.
 * The input given would be an array of integers containing the data. We have to return if the data in the array
 * represents a valid UTF-8 encoding. The important thing to note here is that the array doesn't contain data for
 * just a single character. As can be seen from the first example, the array can contain data for multiple characters
 * all of which can be valid UTF-8 characters and hence the charset represented by the array is valid.
 * Another important thing to note is that the integers in the array can be larger than 255 as well. The highest
 * number that can be represented by 8 bits is 255. So, what do we do if an integer in the array is say, 476?
 * According to the Note in the problem before the examples, we only have to consider the 8 least significant bits of
 * each integer in the array.
 */
public class UTF8Validation393 {


    public static void main(String args[]) {
        int v[] = {197, 130, 1};
        System.out.println(isValidUTF8(v));


        int v2[] = {235, 140, 4};
        System.out.println(isValidUTF8(v2));

        int v3[] = {250, 145, 145, 145, 145};
        System.out.println(isValidUTF8(v3));
    }


    public static boolean isValidUTF8(int data[]) {


        int bitAtPosition8IsOne = 128;//In binary it is : 10000000


        int firstBitOne = 1 << 7;
        int secondBitOne = 1 << 6;
        int numberOfBit = 0;
        for (int count = 0; count < data.length; count++) {

            if (numberOfBit == 0) {

                int d = data[count];

                while ((firstBitOne & d) != 0) {
                    numberOfBit++;
                    d = d << 1;
                }

                if (numberOfBit == 0) {
                    continue;
                }

                if (numberOfBit == 1 || numberOfBit > 4) {
                    return false;
                }


            } else {
                if (!((firstBitOne & data[count]) != 0 && (secondBitOne & data[count]) == 0)) {
                    return false;
                }
            }
            numberOfBit--;
        }


        return numberOfBit == 0;
    }

}
