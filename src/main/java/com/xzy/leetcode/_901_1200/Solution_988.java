package com.xzy.leetcode._901_1200;

import com.xzy.common.TreeNode;

/**
 * @author xiazhengyue
 * @since 2019-02-28
 */
public class Solution_988 {

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(25);
//        treeNode.left = new TreeNode(1);
//        treeNode.left.left = new TreeNode(1);
//        treeNode.left.right = new TreeNode(3);
//
//        treeNode.right = new TreeNode(3);
//        treeNode.right.left = new TreeNode(0);
//        treeNode.right.right = new TreeNode(2);
//
//        System.out.println(smallestFromLeaf(treeNode));

        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(1);
        treeNode.left.right.left = new TreeNode(1);

        treeNode.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(0);
        System.out.println(smallestFromLeaf(treeNode));

    }

    public static String smallestFromLeaf(TreeNode root) {
        char val = (char) ('a' + root.val);
        String l = null, r = null;
        if (root.left != null) {
            l = smallestFromLeaf(root.left);
        }
        if (root.right != null) {
            r = smallestFromLeaf(root.right);
        }
        if (l == null && r == null)
            return "" + val;
        if (l == null)
            return r + val;
        if (r == null)
            return l + val;
        return l.compareTo(r) > 0 ? r + val : l + val;
    }

}
