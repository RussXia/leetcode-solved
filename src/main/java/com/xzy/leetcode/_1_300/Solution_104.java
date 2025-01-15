package com.xzy.leetcode._1_300;

import com.xzy.common.TreeNode;

public class Solution_104 {

    public int maxDepth(TreeNode root) {
        return maxSubTreeDepth(root, 0);
    }

    private static int maxSubTreeDepth(TreeNode sub, int currentDepth) {
        if (sub == null) {
            return currentDepth;
        }
        int subLeftTreeDepth = maxSubTreeDepth(sub.left, currentDepth + 1);
        int subRightTreeDepth = maxSubTreeDepth(sub.right, currentDepth + 1);
        return Math.max(subLeftTreeDepth, subRightTreeDepth);
    }
}
