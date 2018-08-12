package com.omt.learn.algo.allAlgos;

import java.util.Set;
import java.util.TreeSet;

public class CountTriangleByMatrix {

	public static void main(String args[]) {

		Set<String> edges = new TreeSet<>();

		edges.add("ab");
		edges.add("ac");
		edges.add("bc");
		edges.add("bd");
		edges.add("be");
		edges.add("ce");
		edges.add("cf");
		edges.add("de");
		edges.add("ef");

		// Set<String> revEd = new HashSet<>();
		Set<Character> points = new TreeSet<>();

		for (String s : edges) {
			// revEd.add(org.apache.commons.lang3.StringUtils.reverse(s));
			char[] pointAry = s.toCharArray();
			points.add(pointAry[0]);
			points.add(pointAry[1]);

		}

		// edges.addAll(revEd);

		// for (Character s : points) {
		// System.out.println(s);
		// }
		countTriangle(edges, points.toArray(new Character[points.size()]));
		// System.out.println();

	}

	public static int countTriangle(Set<String> setOfConnections, Character[] points) {

		int n = points.length;
		int[][] adgMatrix = new int[n][n];

		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (setOfConnections.contains(String.valueOf(points[i]) + String.valueOf(points[j]))
						|| setOfConnections.contains(String.valueOf(points[j]) + String.valueOf(points[i]))) {
					adgMatrix[i][j] = 1;
				}
			}
		}

		printMatrix(adgMatrix);
		int[][] squreMatrix = mulMatrix(adgMatrix, adgMatrix);

		System.out.println("-------");

		printMatrix(squreMatrix);

		return 0;

	}

	public static int[][] mulMatrix(int[][] m1, int[][] m2) {
		int n = m1.length;

		int[][] mulMatrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			int c1 = 0;
			int c2 = 0;
			for (int j = 0; j < n * n; j++) {

				if (c1 == n) {
					c1 = 0;
					c2++;
				}
				mulMatrix[i][c2] += m1[i][c1] * m2[c1][c2];

				c1++;

			}
		}

		return mulMatrix;

	}

	public static void printMatrix(int[][] i) {
		for (int[] p : i) {
			for (int px : p) {
				if (px > 9) {
					System.out.print(px + " ");
				} else {
					System.out.print(px + "  ");
				}
			}
			System.out.println();
		}
	}
}
