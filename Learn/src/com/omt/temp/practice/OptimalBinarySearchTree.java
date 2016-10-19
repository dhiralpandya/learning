package com.omt.temp.practice;

public class OptimalBinarySearchTree {

	public static void main(String[] args) {

		int keys[] = { 10, 12, 16, 21 };// { 10, 12, 20, 35, 46 };
		int freq[] = { 4, 2, 6, 3 };// { 34, 8, 50, 21, 16 };
		int gotRoot = initOptimalBinary(keys, freq);
		
		System.out.println(gotRoot);

	}

	public static int initOptimalBinary(int key[], int freq[]) {

		int root[][] = new int[freq.length][freq.length];
		int cal[][] = new int[freq.length][freq.length];

		for (int l = 1; l <= freq.length; l++) {

			for (int i = 0; i < freq.length - (l - 1); i++) {

				if (l == 1) {
					cal[i][i] = freq[i];
					root[i][i] = i;
				} else {

					//if (i + l - 1 < freq.length) {
						int total = freq[i];
						root[i][i + l - 1] = i;
						cal[i][i + l - 1] = cal[i + 1][i + l - 1];

						for (int j = i + 1; j < i + l; j++) {

							total += freq[j];
							int temp = cal[i][j - 1];

							if (j + 1 < i + l) {
								temp += cal[j + 1][i + l - 1];
							}

							if (cal[i][i + l - 1] > temp) {
								cal[i][i + l - 1] = temp;
								root[i][i + l - 1] = j;	
							}

						}
						cal[i][i + l - 1] +=total;
					//}

				}

			}

		}

		return root[0][freq.length - 1];

	}
}
