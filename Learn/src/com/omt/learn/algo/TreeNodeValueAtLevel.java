package com.omt.learn.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.omt.learn.algo.util.tree.TreeNodeWithValue;

public class TreeNodeValueAtLevel {

	public static void main(String[] args) {
		System.out.println("Find In Same Level :" + isXandYInSameLevel(generateTree(), 37, 23));

	}

	public static boolean isXandYInSameLevel(TreeNodeWithValue root, int x, int y) {

		Map<Integer, List<TreeNodeWithValue>> nodeAtEachLevelMap = new HashMap<>();
		List<TreeNodeWithValue> listOfNodes = new ArrayList<>();
		listOfNodes.add(root);
		int level = 0;
		nodeAtEachLevelMap.put(level, listOfNodes);

		while (nodeAtEachLevelMap.containsKey(level)) {
			List<TreeNodeWithValue> list = new ArrayList<>();
			boolean xFound = false;
			boolean yFound = false;

			for (TreeNodeWithValue tn : nodeAtEachLevelMap.get(level)) {

				if (!xFound && tn.x == x) {
					xFound = true;
				}

				if (!yFound && tn.y == y) {
					yFound = true;
				}

				if (xFound && yFound) {
					return true;
				}

				if (tn.leftNode != null) {
					list.add((TreeNodeWithValue) (tn.leftNode));
				}

				if (tn.rightNode != null) {
					list.add((TreeNodeWithValue) tn.rightNode);
				}

			}

			++level;
			if (!list.isEmpty()) {
				nodeAtEachLevelMap.put(level, list);
			}

		}

		return false;

	}

	public static TreeNodeWithValue generateTree() {
		TreeNodeWithValue AVL = new TreeNodeWithValue(
				new TreeNodeWithValue(new TreeNodeWithValue(27, 37, "D"), new TreeNodeWithValue(17, 78, "E"), 37, 88,
						"B"),
				new TreeNodeWithValue(null, new TreeNodeWithValue(25, 44, "F"), 22, 23, "C"), 1, 120, "A");
		return AVL;
	}

}
