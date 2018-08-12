package com.omt.learn.algo.allAlgos;

import com.omt.learn.algo.util.matrix.MatrixUtil;
import com.omt.learn.algo.util.tree.BiTreeNode;
import com.omt.learn.algo.util.tree.TreeUtil;

public class OptimalBinarySearchTree {

	public static void main(String[] args) {
		int keys[] = { 10, 12, 16, 21 };// { 10, 12, 20, 35, 46 };
		int freq[] = { 4, 2, 6, 3 };// { 34, 8, 50, 21, 16 };
		int gotRoot = initOptimalBinary(keys, freq);
		generateTree(gotRoot, keys);

	}

	public static void generateTree(int gotRoot, int a[]) {
		BiTreeNode root = new BiTreeNode("" + a[gotRoot]);
		root.value = a[gotRoot];

		for (int i = 0; i < a.length; i++) {
			if (i != gotRoot) {
				BiTreeNode n = new BiTreeNode("" + a[i]);
				n.value = a[i];
				root.addBiTreeNode(n);
			}
		}

		System.out.println("Generated Tree Is :");
		TreeUtil.printTree(root);

	}

	public static int initOptimalBinary(int a[], int b[]) {
		int[][] cal = new int[a.length][a.length];
		int[][] roots = new int[a.length][a.length];

		for (int l = 1; l <= a.length; l++) {

			for (int i = 0; i < a.length; i++) {

				if (l == 1) {
					cal[i][i] = b[i];
					roots[i][i] = i;
				} else if (i + l <= a.length) {

					// Consider i is a root
					int total = b[i];
					roots[i][i + l - 1] = i;
					cal[i][i + l - 1] = cal[i + 1][i + l - 1];

					for (int j = i + 1; j < i + l; j++) {
						// Test what if current j is a root
						total += b[j];
						int temp = cal[i][j - 1];
						// make sure it should not be a index out of bound.
						if (j + 1 < i + l) {
							temp += cal[j + 1][i + l - 1];
						}
						// Check if current j is a capable for root position.
						if (temp < cal[i][i + l - 1]) {
							cal[i][i + l - 1] = temp;
							roots[i][i + l - 1] = j;
						}
					}

					cal[i][i + l - 1] += total; // Add all total in final
												// result.

				}
			}

		}

		System.out.println("Total search cost :");
		MatrixUtil.printMatrix(cal);

		System.out.println();

		System.out.println("Roots selected :");
		MatrixUtil.printMatrix(roots);

		return roots[0][a.length - 1];

	}

}
