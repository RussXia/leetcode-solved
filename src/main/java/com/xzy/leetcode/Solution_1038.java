package com.xzy.leetcode;

import com.xzy.common.TreeNode;

/**
 * @author xiazhengyue
 * @since 2021-03-17
 */
public class Solution_1038 {
    int pre = 0;

    public static void main(String[] args) {
        Solution_1038 solution_1038 = new Solution_1038();
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.right = new TreeNode(3);

        treeNode.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(8);
        System.out.println(solution_1038.bstToGst(treeNode));

    }

    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) {
            bstToGst(root.right);
        }
        pre = root.val + pre;
        root.val = pre;

        if (root.left != null) {
            bstToGst(root.left);
        }
        return root;
    }

}
