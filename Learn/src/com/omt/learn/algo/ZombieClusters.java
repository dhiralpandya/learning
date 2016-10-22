package com.omt.learn.algo;

import java.util.Scanner;

public class ZombieClusters {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);

		int n = Integer.parseInt(sn.nextLine());
		int[][] input = new int[n][n];

		for (int i = 0; i < n; i++) {
			String s = sn.nextLine();
			for (int j = 0; j < n; j++) {
				input[i][j] = Integer.parseInt("" + s.charAt(j));
			}
		}

		System.out.println(count(input, n));
	}

	static int zombieCluster(String[] zombies) {
		int n = zombies.length;
		int[][] input = new int[n][n];

		for (int i = 0; i < n; i++) {
			String s = zombies[i];
			for (int j = 0; j < n; j++) {
				input[i][j] = Integer.parseInt("" + s.charAt(j));
			}
		}

		return count(input, n);
	}

	public static int count(int[][] input, int n) {
		int count = 1;

		boolean b[] = new boolean[n];

		boolean lastFound = false;
		for (int i = 1; i < n; i++) {
			boolean isFound = false;
			for (int j = i + 1; j < n; j++) {
				if (input[i][j] == 1) {
					isFound = true;
					b[j] = true;
					if (input[i - 1][j - 1] == 0) {
						count++;
					}

					if (j == n - 1) {
						lastFound = true;
					}
				}

			}

			if (!b[i] && !isFound && i != n - 1) {
				count++;
			}
		}
		if (!lastFound) {
			count++;
		}
		return count;
	}

}
