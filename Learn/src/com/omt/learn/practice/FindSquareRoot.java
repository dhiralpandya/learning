package com.omt.learn.practice;

import java.math.BigInteger;

public class FindSquareRoot {

	public static void main(String[] args) {
		System.out.println(squareRoot(25));
		System.out.println(squareRoot(257787));
		System.out.println(squareRoot(257));

	}

	public static int squareRoot(int num) {

		BigInteger bigIntegerNum = new BigInteger(String.valueOf(num));
		BigInteger bigIntegerStart = new BigInteger("0");
		BigInteger bigIntegerEnd = new BigInteger(String.valueOf(num));
		BigInteger bigIntegerSR = new BigInteger("0");

		while (bigIntegerStart.compareTo(bigIntegerEnd) <= 0) {

			BigInteger bigIntegerMid = bigIntegerStart.add(bigIntegerEnd).divide(new BigInteger("2"));

			BigInteger midXmid = bigIntegerMid.multiply(bigIntegerMid);

			if (midXmid.compareTo(bigIntegerNum) < 0) {
				bigIntegerSR = new BigInteger(bigIntegerMid.toByteArray());
				bigIntegerStart = bigIntegerMid.add(new BigInteger("1"));
			} else if (midXmid.compareTo(bigIntegerNum) > 0) {
				bigIntegerEnd = bigIntegerMid.subtract(new BigInteger("1"));
			} else {
				return bigIntegerMid.intValue();
			}

		}

		return bigIntegerSR.intValue();
	}

}
