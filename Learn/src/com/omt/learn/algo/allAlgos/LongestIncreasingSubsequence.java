package com.omt.learn.algo.allAlgos;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int a[] = { 3, 4, -1, 0, 6, 2, 3 };
		calculateLongestincreasingSubsequence(a);
	}

	public static void calculateLongestincreasingSubsequence(int a[]) {

		int len[] = new int[a.length];
		int val[] = new int[a.length];

		val[0] = a[0];
		int maxValue = 0;
		int maxLenght = 0;
		int maxValueAt = 0;
		int maxLengthAt = 0;

		for (int i = 1; i < a.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (a[i] > a[j]) {
					len[i] = len[j] + 1;
					val[i] = a[i] + val[j];
					if (len[i] > maxLenght) {
						maxLenght = len[i];
						maxLengthAt = i;
					}

					if (val[i] > maxValue) {
						maxValueAt = i;
						maxValue = val[i];
					}
					break;
				} else {
					val[i] = a[i];
				}
			}
		}

		System.out.println("Max Lenght :" + (maxLenght + 1));
		System.out.println("Max value :" + maxValue);

		for (int v : val) {
			System.out.println(v);
		}

	}

}
