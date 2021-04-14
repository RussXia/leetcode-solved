package com.xzy.leetcode._901_1200;

import com.xzy.common.TreeNode;

import java.util.Objects;

/**
 * @author xiazhengyue
 * @since 2019-01-31
 */
public class Solution_951 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(2);
        root1.left.right = new TreeNode(6);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(3);
        root1.right.left.left = new TreeNode(5);
        root1.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(1);
        root2.right.left = new TreeNode(2);
        root2.right.left.left = new TreeNode(6);
        root2.right.right = new TreeNode(3);
        root2.right.right.left = new TreeNode(5);
        System.out.println(flipEquiv(root1, root2));
    }

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        if (!Objects.equals(root1.val, root2.val))
            return false;
        return (flipEquiv(root1.left, root2.right)
                && flipEquiv(root1.right, root2.left))
                || (
                flipEquiv(root1.left, root2.left)
                        && flipEquiv(root1.right, root2.right)
        );
    }

    private static boolean checkNodeNum(TreeNode root1, TreeNode root2) {
        int leafNode1 = 0;
        if (root1.left != null)
            leafNode1++;
        if (root1.right != null)
            leafNode1++;
        int leafNode2 = 0;
        if (root2.left != null)
            leafNode2++;
        if (root2.right != null)
            leafNode2++;
        return leafNode1 == leafNode2;
    }
}
