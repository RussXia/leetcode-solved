package com.xzy.leetcode;

import java.util.Objects;

/**
 * @author xiazhengyue
 * @since 2019-01-31
 */
public class FlipEquivalentBinaryTrees951 {

    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(1);
//        treeNode1.left = new TreeNode(2);
//        treeNode1.left.left = new TreeNode(4);
//        treeNode1.left.right = new TreeNode(5);
//        treeNode1.left.right.left = new TreeNode(7);
//        treeNode1.left.right.right = new TreeNode(8);
//
//        treeNode1.right = new TreeNode(3);
//        treeNode1.right.left = new TreeNode(6);
//
//        TreeNode treeNode2 = new TreeNode(1);
//        treeNode2.left = new TreeNode(3);
//        treeNode2.left.right = new TreeNode(6);
//
//        treeNode2.right = new TreeNode(2);
//        treeNode2.right.left = new TreeNode(4);
//        treeNode2.right.right = new TreeNode(5);
//        treeNode2.right.right.left = new TreeNode(8);
//        treeNode2.right.right.right = new TreeNode(7);
//
//        System.out.println(flipEquiv(treeNode1, treeNode2));

        TreeNode treeNode3 = new TreeNode(0);
        treeNode3.left = new TreeNode(3);
        treeNode3.right = new TreeNode(1);
        treeNode3.right.right = new TreeNode(2);

        TreeNode treeNode4 = new TreeNode(0);
        treeNode4.left = new TreeNode(3);
        treeNode4.left.left = new TreeNode(2);
        treeNode4.right = new TreeNode(1);
        System.out.println(flipEquiv(treeNode3, treeNode4));

    }

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (!Objects.equals(root1.val, root2.val)) {
            return false;
        }
        if(flipEquiv(root1.left, root2.right)
                || flipEquiv(root1.right, root2.left)
                || flipEquiv(root1.left, root2.left)
                || flipEquiv(root1.right, root2.right)) {
            return true;
        }
        return false;
    }
}
