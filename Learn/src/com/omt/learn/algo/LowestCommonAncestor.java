package com.omt.learn.algo;

import com.omt.learn.algo.util.tree.TreeNode;
import com.omt.learn.algo.util.tree.TreeUtil;

/**
 * Created by dhira on 12-03-2017.
 */
public class LowestCommonAncestor {


    public static void main(String... args) {
     TreeNode tn = TreeUtil.generateTree(3);

        System.out.println(tn.value);
        System.out.println(tn.leftNode.value+"   "+tn.rightNode.value);
        System.out.println(tn.leftNode.leftNode.value+"   "+tn.leftNode.rightNode.value+"   "+tn.rightNode.leftNode.value+"  "+tn.rightNode.rightNode.value);

    }



}
