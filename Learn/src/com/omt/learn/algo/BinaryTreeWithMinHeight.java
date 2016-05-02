package com.omt.learn.algo;

import java.util.Arrays;

import com.omt.learn.algo.util.tree.TreeNode;

public class BinaryTreeWithMinHeight {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		Arrays.sort(a);

		TreeNode tn = createTreeWithMinHeight(a, 0, a.length - 1);

		IsAVLTree.printTree(tn);

	}

	public static TreeNode createTreeWithMinHeight(int a[], int start, int end) {

		if (start > end) {
			return null;
		}

		int middle = (start + end) / 2;

		TreeNode tn = new TreeNode(createTreeWithMinHeight(a, start, middle - 1),
				createTreeWithMinHeight(a, middle + 1, end), String.valueOf(a[middle]));

		return tn;
	}

}