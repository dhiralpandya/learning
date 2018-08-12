package com.omt.learn.algo.allAlgos;

import java.util.Scanner;

public class CircularArrayRotation {

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		String[] lineOne = sn.nextLine().split("\\s+");
		String[] lineTwo = sn.nextLine().split("\\s+");

		int size = Integer.parseInt(lineOne[0]);
		int rotate = Integer.parseInt(lineOne[1]);
		int querySize = Integer.parseInt(lineOne[2]);

		int[] qInt = new int[querySize];

		for (int i = 0; i < querySize; i++) {
			qInt[i] = Integer.parseInt(sn.nextLine());
		}

		for (int position : qInt) {
			System.out.println("Poositions:" + position);
			System.out.println(find(lineTwo, rotate, position, size));
		}

	}

	public static int find(String a[], int rotation, int position, int size) {

		int index = size - rotation + position;

		return getElement(a, index, size);
	}

	public static int getElement(String a[], int index, int size) {
		if (index == size) {
			return Integer.parseInt(a[0]);
		} else if (index > size) {
			int div = Math.abs(index) / size;
			index -= (div * size);
			return getElement(a, index, size);
		} else if (index < 0) {
			if (Math.abs(index) > size) {
				int div = Math.abs(index) / size;
				index += (div * size);
			} else {
				index += size;
			}
			return getElement(a, index, size);
		} else {
			return Integer.parseInt(a[index]);
		}

	}

}
