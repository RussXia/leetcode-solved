package com.xzy.leetcode;

import com.xzy.common.TreeNode;

/**
 * @author xiazhengyue
 * @since 2021-04-08
 */
public class Solution_100 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return (p == q);
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
