package com.xzy.leetcode;

import com.alibaba.fastjson.JSON;
import com.xzy.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-03-30
 */
public class Solution_971 {
    private List<Integer> match = new ArrayList<>();
    private int index = 0;

    public static void main(String[] args) {
        {
            Solution_971 solution = new Solution_971();
            int[] voyage = {2, 4, 3, 1, 5};
            TreeNode treeNode = new TreeNode(2);
            treeNode.left = new TreeNode(1);
            treeNode.left.left = new TreeNode(5);

            treeNode.right = new TreeNode(4);
            treeNode.right.left = new TreeNode(3);

            System.out.println(JSON.toJSON(solution.flipMatchVoyage(treeNode, voyage)));
        }
        {
            Solution_971 solution = new Solution_971();
            int[] voyage = {2, 6, 3, 4, 5, 7, 1};
            TreeNode treeNode = new TreeNode(2);
            treeNode.left = new TreeNode(3);
            treeNode.left.left = new TreeNode(4);
            treeNode.left.left.left = new TreeNode(7);
            treeNode.left.left.right = new TreeNode(5);
            treeNode.left.left.left.right = new TreeNode(1);

            treeNode.right = new TreeNode(6);

            System.out.println(JSON.toJSON(solution.flipMatchVoyage(treeNode, voyage)));
        }
        {
            Solution_971 solution = new Solution_971();
            int[] voyage = {1, 3, 2};
            TreeNode treeNode = new TreeNode(1);
            treeNode.left = new TreeNode(2);
            treeNode.left.left = new TreeNode(3);

            System.out.println(JSON.toJSON(solution.flipMatchVoyage(treeNode, voyage)));
        }
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (!preOrderRecursive(root, voyage, match)) {
            return Arrays.asList(-1);
        }
        return match;
    }

    private boolean preOrderRecursive(TreeNode root, int[] voyage, List<Integer> match) {
        if (root == null) {
            return true;
        }
        if (root.val != voyage[index]) {
            return false;
        }
        //判断是否需要交换左右节点
        if (root.left != null && root.right != null && root.left.val != voyage[index + 1] && root.right.val == voyage[index + 1]) {
            //记录交换的节点
            match.add(root.val);
            switchNode(root);
        }
        index++;
        return preOrderRecursive(root.left, voyage, match) && preOrderRecursive(root.right, voyage, match);
    }

    private void switchNode(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
    }
}
