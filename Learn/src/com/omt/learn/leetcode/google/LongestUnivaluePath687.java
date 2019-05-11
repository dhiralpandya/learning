package com.omt.learn.leetcode.google;

import com.omt.learn.algo.util.tree.TreeNode;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path
 * may or may not pass through the root.
 * <p>
 * The length of path between two nodes is represented by the number of edges between them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class LongestUnivaluePath687 {


    public static void main(String args[]) {
        System.out.println(new Solution(getRootNode1()).getMaxCount());
        System.out.println(new Solution(getRootNode2()).getMaxCount());
        System.out.println(new Solution(getRootNode3()).getMaxCount());
        System.out.println(new Solution(getRootNode4()).getMaxCount());
    }

    static class Solution {
        private TreeNode root;
        public int maxCount = 0;

        private Solution(TreeNode root) {
            this.root = root;
            count(root);
        }


        private int count(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftCount = count(root.leftNode);
            int rightCount = count(root.rightNode);

            int totalCount = 0;

            if ((root.leftNode != null && root.value == root.leftNode.value) && (root.rightNode != null && root.value == root.rightNode.value)) {
                totalCount = leftCount + rightCount + 2;
            } else if (root.leftNode != null && root.value == root.leftNode.value) {
                totalCount = leftCount + 1;
            } else if (root.rightNode != null && root.value == root.rightNode.value) {
                totalCount = rightCount + 1;
            }

            maxCount = Math.max(totalCount, maxCount);

            return totalCount;
        }

        public int getMaxCount() {
            return maxCount;
        }

    }


    public static TreeNode getRootNode1() {
        TreeNode t1l = new TreeNode("", 1);
        TreeNode t1r = new TreeNode("", 1);
        TreeNode t4 = new TreeNode(t1l, t1r, "", 4);
        TreeNode t5rr = new TreeNode("", 5);
        TreeNode t5r = new TreeNode(null, t5rr, "", 5);

        TreeNode treeNode = new TreeNode(t4, t5r, "", 5);

        return treeNode;
    }

    public static TreeNode getRootNode2() {
        TreeNode t1l = new TreeNode("", 1);
        TreeNode t1r = new TreeNode("", 1);
        TreeNode t4 = new TreeNode(t1l, t1r, "", 5);
        TreeNode t5rr = new TreeNode("", 5);
        TreeNode t5r = new TreeNode(null, t5rr, "", 5);

        TreeNode treeNode = new TreeNode(t4, t5r, "", 5);

        return treeNode;
    }

    public static TreeNode getRootNode3() {
        TreeNode t1l = new TreeNode("", 4);
        TreeNode t1r = new TreeNode("", 4);
        TreeNode t4 = new TreeNode(t1l, t1r, "", 4);
        TreeNode t5rr = new TreeNode("", 5);
        TreeNode t5r = new TreeNode(null, t5rr, "", 5);

        TreeNode treeNode = new TreeNode(t4, t5r, "", 1);

        return treeNode;
    }


    public static TreeNode getRootNode4() {
        TreeNode t1l = new TreeNode("", 5);
        TreeNode t1r = new TreeNode("", 5);
        TreeNode t4 = new TreeNode(t1l, t1r, "", 5);
        TreeNode t5rr = new TreeNode("", 5);
        TreeNode t5r = new TreeNode(null, t5rr, "", 5);

        TreeNode treeNode = new TreeNode(t4, t5r, "", 5);

        return treeNode;
    }

}
