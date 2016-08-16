package com.omt.learn.algo.util.tree;

public class TreeNode {

	public String nodeName = "";
	public boolean isVisited = false;
	public int value = 0;
	public TreeNode leftNode = null;
	public TreeNode rightNode = null;
	public TreeNode parentNode = null;

	public TreeNode() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode(String name) {
		nodeName = name;
	}

	public TreeNode(String name, int value) {
		this(name);
		this.value = value;
	}

	public TreeNode(TreeNode left, TreeNode right, String name) {
		leftNode = left;
		rightNode = right;
		nodeName = name;
		setParent();
	}

	protected void setParent() {
		if (leftNode != null) {
			leftNode.parentNode = this;
		}

		if (rightNode != null) {
			rightNode.parentNode = this;
		}
	}

}
