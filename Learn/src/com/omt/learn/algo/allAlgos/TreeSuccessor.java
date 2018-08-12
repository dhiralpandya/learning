package com.omt.learn.algo.allAlgos;

import com.omt.learn.algo.util.tree.TreeNode;

public class TreeSuccessor {

	public static void main(String[] args) {

		TreeNode find = new TreeNode(new TreeNode("11"), null, "12");
		TreeNode root = generateTree(find);

		System.out.println(successor(find).nodeName);

	}

	public static TreeNode successor(TreeNode n) {

		if (n.rightNode != null) {
			return leftMostNode(n.rightNode);
		}

		return parentSuccessor(n);

	}

	public static TreeNode parentSuccessor(TreeNode n) {

		TreeNode p = n.parentNode;

		while (p != null) {
			if (p.leftNode == n) {
				return p;
			}

			n = p;
			p = p.parentNode;
		}

		return p;
	}

	public static TreeNode leftMostNode(TreeNode n) {

		if (n == null) {
			return null;
		}

		while (n.leftNode != null) {
			n = n.leftNode;
		}

		return n;

	}

	public static TreeNode generateTree(TreeNode findingNode) {

		TreeNode n = new TreeNode(new TreeNode(new TreeNode(new TreeNode("6"), null, "8"), findingNode, "10"),
				new TreeNode(new TreeNode(new TreeNode("16"), null, "17"), new TreeNode(null, new TreeNode("27"), "25"),
						"20"),
				"15");

		return n;

	}

}