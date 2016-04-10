package com.omt.learn;

import java.util.Date;

public class CommuteWithJVM {

	public static void main(String args[]) {

		Runtime omt = Runtime.getRuntime();
		System.out.println("Capacity In bytes  : " + (omt.maxMemory()));
		System.out.println("Capacity In mb  : " + (omt.maxMemory() / 1000000));

		long byteFree = omt.freeMemory();
		System.out.println("Free Memory In bytes  : " + (byteFree));

		for (int count = 0; count < 10000; count++) {
			Date d = new Date();
		}

		System.out.println("Used Memory In bytes  : " + (byteFree - omt.freeMemory()));

		System.out.println("Running GC");
		omt.gc();

		System.out.println("Now After GC Memory In bytes  : " + (omt.freeMemory()));
	}

}
