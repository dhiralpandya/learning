package com.omt.learn.algo.allAlgos;

import java.util.Set;
import java.util.TreeSet;

import com.omt.learn.algo.util.tree.TreeNode;

public class DuplicateTreeInTree {

	public static void main(String[] args) {
		System.out.println("Is Duplicate Sub Trees :" + isContainsDuplicateTrees(generateTree()));
	}

	public static boolean isContainsDuplicateTrees(TreeNode root) {

		return isContainsDuplicateTrees(new TreeSet<>(), root);
	}

	public static boolean isContainsDuplicateTrees(Set<String> trees, TreeNode root) {

		if (root != null) {
			String tree = "";
			if (root.leftNode != null) {
				tree += root.leftNode.nodeName;
			}

			tree += root.nodeName;

			if (root.rightNode != null) {
				tree += root.rightNode.nodeName;
			}

			if (trees.contains(tree)) {
				System.out.println(tree);
				return true;
			}
			if (tree.length() == 3) {
				System.out.println(tree);
				trees.add(tree);
			}
			boolean isLeftHave = false;
			if (root.leftNode != null) {
				isLeftHave = isContainsDuplicateTrees(trees, root.leftNode);
			}

			boolean isRightHave = false;
			if (root.rightNode != null) {
				isRightHave = isContainsDuplicateTrees(trees, root.rightNode);
			}

			return (isLeftHave || isRightHave);

		}
		return false;
	}

	public static TreeNode generateTree() {
		TreeNode AVL = new TreeNode(new TreeNode(new TreeNode("D"), new TreeNode("E"), "B"),
				new TreeNode(new TreeNode("I"),
						new TreeNode(new TreeNode("H"), new TreeNode(new TreeNode("D"), new TreeNode("E"), "B"), "F"),
						"C"),
				"A");
		return AVL;
	}
}
