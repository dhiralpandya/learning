package com.omt.learn.algo.allAlgos;

public class BitShifting {

	public static void main(String[] args) {

		byte a = -7;
		byte s = 10;

		System.out.println(String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0'));

		System.out.println(arithmeticBitShifting(a, s));

	}

	public static byte arithmeticBitShifting(byte a, byte shifUpto) {
		a = (byte) (a >> shifUpto);
		System.out.println(String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0'));
		return a;
	}

}
