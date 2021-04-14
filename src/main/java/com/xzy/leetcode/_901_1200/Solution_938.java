package com.xzy.leetcode._901_1200;

import com.xzy.common.TreeNode;

/**
 * @author xiazhengyue
 * @since 2019-02-28
 */
public class Solution_938 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);

        System.out.println(rangeSumBST(root, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val < L) {
            sum += rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            sum += rangeSumBST(root.left, L, R);
        } else {
            sum += root.val;
            sum += rangeSumBST(root.left, L, R);
            sum += rangeSumBST(root.right, L, R);
        }
        return sum;
    }
}
