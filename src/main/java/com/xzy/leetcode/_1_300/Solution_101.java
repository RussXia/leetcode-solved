package com.xzy.leetcode._1_300;

import com.xzy.common.TreeNode;

import java.util.Objects;

public class Solution_101 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (!Objects.equals(left.val, right.val)) {
            return false;
        }
        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }
}
