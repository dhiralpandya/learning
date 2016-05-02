package com.omt.learn.algo;

import com.omt.learn.algo.util.tree.TreeNode;

public class IsAVLTree {

	public static void main(String[] args) {
		TreeNode root = generateTree();
		printTree(root);

		System.out.println("--------------\n\n");
		System.out.println("Max Depth :" + findMaxDepth(root));
		System.out.println("Min Depth :" + findMinDepth(root) + " \n\n");
		System.out.println("--------------");

		System.out.println("Is AVL Tree :" + isAVLTree(root));

	}

	public static boolean isAVLTree(TreeNode root) {

		return (findMaxDepth(root) - findMinDepth(root)) <= 1;
	}

	public static int findMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(findMaxDepth(root.leftNode), findMaxDepth(root.rightNode));
	}

	public static int findMinDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.min(findMinDepth(root.leftNode), findMinDepth(root.rightNode));
	}

	public static TreeNode generateTree() {
		// TreeNode AVL = new TreeNode(new TreeNode(new TreeNode("D"), new
		// TreeNode("E"), "B"), new TreeNode("C"), "A");
		TreeNode notAVL = new TreeNode(new TreeNode(new TreeNode("D"), new TreeNode("E"), "B"),
				new TreeNode(null, new TreeNode(null, new TreeNode(null, new TreeNode("H"), "G"), "F"), "C"), "A");
		return notAVL;
	}

	public static void printTree(TreeNode root) {
		int rootPosition = findMaxDepth(root) * 3;
		printTree(root, rootPosition);
	}

	public static void printTree(TreeNode root, int rootPosition) {

		if (root != null) {
			String s = getSpace(rootPosition) + root.nodeName;
			System.out.println(s);
			printTree(root.rightNode, rootPosition + 3);
			printTree(root.leftNode, rootPosition - 3);
		}

	}

	public static String getSpace(int n) {

		String s = "";

		for (int i = 0; i < n; i++) {
			s += " ";
		}

		return s;
	}

}
