package com.omt.learn.algo.util.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtil {
	public static int findMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(findMaxDepth(root.leftNode), findMaxDepth(root.rightNode));
	}

	public static void printTree(TreeNode root) {
		System.out.println();
		int rootPosition = findMaxDepth(root) * 3;
		printTree(root, rootPosition);
	}

	public Map<Integer, List<TreeNode>> levelWithNodes(TreeNode root) {
		int currentLevel = 0;

		Map<Integer, List<TreeNode>> map = new HashMap<>();
		List<TreeNode> l = new ArrayList<TreeNode>();
		l.add(root);
		map.put(currentLevel, l);

		while (map.containsKey(currentLevel)) {
			List<TreeNode> t = new ArrayList<>();
			for (TreeNode n : map.get(currentLevel)) {
				if (n.leftNode != null) {
					t.add(n.leftNode);
				}

				if (n.rightNode != null) {
					t.add(n.rightNode);
				}
			}
			currentLevel++;

			if (t.size() > 0) {
				map.put(currentLevel, t);
			}

		}

		return map;

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
