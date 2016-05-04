package com.omt.learn.algo.util.tree;

public class TreeNodeWithValue extends TreeNode {

	public int x = 0;
	public int y = 0;

	public TreeNodeWithValue(int x, int y, String name) {
		super(name);
		this.x = x;
		this.y = y;
	}

	public TreeNodeWithValue(TreeNodeWithValue left, TreeNodeWithValue right, int x, int y, String name) {
		super(left, right, name);
		this.x = x;
		this.y = y;
	}

}
