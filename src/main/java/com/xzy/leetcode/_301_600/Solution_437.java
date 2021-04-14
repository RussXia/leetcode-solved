package com.xzy.leetcode._301_600;

import com.xzy.common.TreeNode;

/**
 * @author xiazhengyue
 * @since 2019-01-25
 */
public class Solution_437 {

    private static int count = 0;

    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int sum) {
        return 0;
    }

    private static int recursionTreeSum(TreeNode treeNode, int currentSum, int expectedSum) {
        if (treeNode == null)
            return currentSum;
        currentSum += treeNode.val;
        if (currentSum == expectedSum)
            count++;
        if (treeNode.left != null) {
            currentSum = recursionTreeSum(treeNode.left, currentSum, expectedSum);
        }
        if (treeNode.right != null) {
            currentSum = recursionTreeSum(treeNode.right, currentSum, expectedSum);
        }
        return currentSum;
    }
}
