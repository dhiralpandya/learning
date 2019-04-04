package com.omt.learn.leetcode.google;

import com.omt.learn.algo.util.tree.TreeNode;

/**
 * Description
 *
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child 
 * connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * 
 * Example
 * Example 1:
 *
 * Input:
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * Output:3
 * Explanation:
 * Longest consecutive sequence path is 3-4-5, so return 3.
 * Example 2:
 *
 * Input:
 *    2
 *     \
 *      3
 *     / 
 *    2    
 *   / 
 *  1
 * Output:2
 * Explanation:
 * Longest consecutive sequence path is 2-3,not 3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence298 {

    public static void main(String args[]) {
        System.out.println(getCount(getRoot()));
        System.out.println(getCount(getRoot2()));
    }


    public static int getCount(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = root.leftNode == null ? 1 : getCount(root.leftNode);
        int rightSum = root.rightNode == null ? 1 : getCount(root.rightNode);

        if (root.rightNode != null && root.rightNode.value == root.value + 1) {
            rightSum++;
        }
        return Math.max(leftSum, rightSum);
    }

    public static TreeNode getRoot() {
        TreeNode tn5 = new TreeNode(null, 5);
        TreeNode tn4 = new TreeNode(null, tn5, null, 4);

        TreeNode tn2 = new TreeNode(null, 2);

        TreeNode tn3 = new TreeNode(tn2, tn4, null, 3);


        TreeNode tn1 = new TreeNode(null, tn3, null, 1);
        return tn1;
    }

    public static TreeNode getRoot2() {
        TreeNode tn1 = new TreeNode(null, 1);
        TreeNode tn2Again = new TreeNode(tn1, null, null, 2);
        TreeNode tn3 = new TreeNode(tn2Again, null, null, 3);
        TreeNode tn2 = new TreeNode(null, tn3, null, 2);
        return tn2;
    }

}
