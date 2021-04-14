package com.xzy.leetcode._901_1200;

import com.xzy.common.TreeNode;

/**
 * @author xiazhengyue
 * @since 2021-04-01
 */
public class Solution_1026 {

    public static void main(String[] args) {
        Solution_1026 solution = new Solution_1026();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println(solution.maxAncestorDiff(root));
    }

    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val);
    }

    private int maxAncestorDiff(TreeNode root, int max, int min) {
        if (root == null) {
            return max - min;
        }
        max = root.val > max ? root.val : max;
        min = root.val < min ? root.val : min;
        return Math.max(maxAncestorDiff(root.left, max, min), maxAncestorDiff(root.right, max, min));
    }
}
