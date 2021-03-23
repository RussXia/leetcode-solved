package com.xzy.leetcode;

import com.xzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-03-17
 */
public class Solution_94 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);

        treeNode.right = new TreeNode(2);
        System.out.println(inorderTraversal(treeNode));

    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> node = new ArrayList<>();
        return inorderRecursive(root, node);
    }

    public static List<Integer> inorderRecursive(TreeNode root, List<Integer> node) {
        if (root == null) {
            return node;
        }
        inorderRecursive(root.left, node);
        node.add(root.val);
        inorderRecursive(root.right, node);
        return node;
    }
}
