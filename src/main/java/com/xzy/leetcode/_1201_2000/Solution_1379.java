package com.xzy.leetcode._1201_2000;

import com.xzy.common.TreeNode;

/**
 * User: RuzzZZ
 * Date: 2023/5/29
 * Time: 11:02
 */
public class Solution_1379 {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || cloned == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        return left != null ? left : right;
    }
}
