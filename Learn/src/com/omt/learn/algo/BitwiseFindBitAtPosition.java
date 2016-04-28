package com.omt.learn.algo;

public class BitwiseFindBitAtPosition {

	public static void main(String[] args) {
		int n = 1387;
		System.out.println(Integer.toBinaryString(n));

		int position = 0;
		System.out.println("Bit at (" + position + ") is :" + getBitAtPosition(n, position));

		position = 2;
		System.out.println("Bit at (" + position + ") is :" + getBitAtPosition(n, position));
	}

	public static int getBitAtPosition(int n, int position) {
		int bit = (n >> position) & 1;
		return bit;
	}

}
