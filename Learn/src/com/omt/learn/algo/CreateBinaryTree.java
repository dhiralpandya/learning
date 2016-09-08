package com.omt.learn.algo;

import com.omt.learn.algo.util.tree.BiTreeNode;
import com.omt.learn.algo.util.tree.TreeNode;
import com.omt.learn.algo.util.tree.TreeUtil;

public class CreateBinaryTree {

	public static void main(String args[]) {
		int rootValue = 27;
		int[] valuesToInsert = { 18, 38, 10, 20, 29, 40 };
		TreeNode root = createBinarySearchTree(rootValue, valuesToInsert);
		TreeUtil.printTree(root);
	}

	public static TreeNode createBinarySearchTree(int rootValue, int valuesToInsert[]) {

		BiTreeNode root = new BiTreeNode("" + rootValue, rootValue);

		for (int value : valuesToInsert) {
			BiTreeNode n = new BiTreeNode("" + value, value);
			root.addBiTreeNode(n);
		}

		return root;

	}

}
