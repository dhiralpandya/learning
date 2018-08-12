package com.omt.learn.algo.allAlgos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.omt.learn.algo.util.tree.TreeNode;

public class TreeNodeAtEachLevel {

	public static void main(String[] args) {
		// IsAVLTree.printTree(generateTree());

		Map<Integer, List<TreeNode>> nodeAtEachLevel = getNodeAtEachLevel(generateTree());
		for (Integer key : nodeAtEachLevel.keySet()) {
			System.out.println("At Level :" + key);
			for (TreeNode tn : nodeAtEachLevel.get(key)) {
				System.out.println(tn.nodeName + " ");
			}
		}

	}

	public static Map<Integer, List<TreeNode>> getNodeAtEachLevel(TreeNode root) {

		Map<Integer, List<TreeNode>> nodeAtEachLevelMap = new HashMap<>();
		List<TreeNode> listOfNodes = new ArrayList<>();
		listOfNodes.add(root);
		int level = 0;
		nodeAtEachLevelMap.put(level, listOfNodes);

		while (nodeAtEachLevelMap.containsKey(level)) {
			List<TreeNode> list = new ArrayList<>();

			for (TreeNode tn : nodeAtEachLevelMap.get(level)) {
				if (tn.leftNode != null) {
					list.add(tn.leftNode);
				}

				if (tn.rightNode != null) {
					list.add(tn.rightNode);
				}

			}
			++level;
			if (!list.isEmpty()) {
				nodeAtEachLevelMap.put(level, list);
			}

		}

		return nodeAtEachLevelMap;

	}

	public static TreeNode generateTree() {
		TreeNode AVL = new TreeNode(new TreeNode(new TreeNode("D"), new TreeNode("E"), "B"),
				new TreeNode(null, new TreeNode("F"), "C"), "A");
		return AVL;
	}
}
