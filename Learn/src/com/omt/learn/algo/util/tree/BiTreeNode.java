package com.omt.learn.algo.util.tree;

public class BiTreeNode extends TreeNode {

	public BiTreeNode() {
		// TODO Auto-generated constructor stub
	}

	public BiTreeNode(String name) {
		super(name);
	}

	public void addBiTreeNode(BiTreeNode node) {
		setBinaryNode(this, node);
	}

	private void setBinaryNode(TreeNode current, TreeNode node) {
		if (current.value > node.value) {
			if (current.leftNode == null) {
				current.leftNode = node;
			} else {
				setBinaryNode(current.leftNode, node);
			}
		} else {
			if (current.rightNode == null) {
				current.rightNode = node;
			} else {
				setBinaryNode(current.rightNode, node);
			}
		}
	}

	public BiTreeNode(TreeNode left, TreeNode right, String name) {
		super(left, right, name);
		super.setParent();
	}

}
