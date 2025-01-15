package com.xzy.leetcode._1_300;

import com.xzy.common.TreeNode;

public class Solution_124 {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public static void main(String[] args) {
        int a = 0;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = maxGain(node.left);
        int rightGain = maxGain(node.right);

        // 左/右/根
        int current = Math.max(Math.max((node.val + leftGain), (node.val + rightGain)), node.val);
        // 左根右 vs 左/右/根 vs 全不选
        maxSum = Math.max(Math.max(node.val + leftGain + rightGain, current), maxSum);
        return current;
    }


}
