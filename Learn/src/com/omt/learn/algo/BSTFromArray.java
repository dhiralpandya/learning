package com.omt.learn.algo;

import com.omt.learn.algo.util.tree.TreeNode;
import com.omt.learn.algo.util.tree.TreeUtil;

import java.util.Arrays;

/**
 * Created by dhpandya on 3/22/17.
 */
public class BSTFromArray {

    public static void main(String args[]) {

        int a[] = {1, 5, 4, 2, 6, 3, 8, 7};

        TreeNode tn = generateBST(a);

        TreeUtil.printTree(tn);

    }


    private static TreeNode generateBST(int a[]) {
        Arrays.sort(a);
        return generateBST(a, 0, a.length);
    }

    private static TreeNode generateBST(int a[], int start, int end) {


        if (start > end) {
            return null;
        }

        TreeNode tn = new TreeNode();

        int mid = (start + end) / 2;

        tn.value = mid;
        tn.nodeName = String.valueOf(mid);

        tn.leftNode = generateBST(a, start, mid - 1);
        tn.rightNode = generateBST(a, mid + 1, end);


        return tn;
    }


}
