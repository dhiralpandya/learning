package com.omt.learn.algo;

import com.omt.learn.algo.util.tree.TreeNode;

/**
 * Created by omt on 3/16/17.
 */
public class LowestCommonAncestor {

    public static void main(String... args) {

        TreeNode root = generateTree();

        System.out.println("Lowest Common Ancestor :" + lowestCommonAncestor(root, "9", "10").nodeName);
        System.out.println("Lowest Common Ancestor :" + lowestCommonAncestor(root, "9", "6").nodeName);

    }

    private static TreeNode lowestCommonAncestor(TreeNode root, String node1, String node2) {
        if (root == null) {
            return null;
        }

        if (root.nodeName.equals(node1) || root.nodeName.equals(node2)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.leftNode, node1, node2);
        TreeNode right = lowestCommonAncestor(root.rightNode, node1, node2);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    public static TreeNode generateTree() {
        TreeNode tn = new TreeNode(
                new TreeNode(new TreeNode(new TreeNode("6"), new TreeNode(new TreeNode("8"), new TreeNode("9"), "7"), "4"),
                        new TreeNode(new TreeNode("10"), new TreeNode("11"), "5"), "2"),
                new TreeNode("3"), "1");

        return tn;
    }


}
