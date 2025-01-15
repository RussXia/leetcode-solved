package com.xzy.leetcode._1_300;

import com.xzy.common.TreeNode;

import java.util.Objects;

public class Solution_112 {


    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return Objects.equals(root.val, targetSum);
        }
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return calcPathSum(root, 0, targetSum);
    }

    private boolean calcPathSum(TreeNode root, int currentSum, int targetSum) {
        if (root == null) {
            return false;
        }
        currentSum += root.val;
        // 根结点
        if (root.left == null && root.right == null) {
            return Objects.equals(currentSum, targetSum);
        }
        if (root.left == null && root.right != null) {
            return calcPathSum(root.right, currentSum, targetSum);
        }
        if (root.right == null && root.left != null) {
            return calcPathSum(root.left, currentSum, targetSum);
        }
        return calcPathSum(root.left, currentSum, targetSum) || calcPathSum(root.right, currentSum, targetSum);
    }
}
