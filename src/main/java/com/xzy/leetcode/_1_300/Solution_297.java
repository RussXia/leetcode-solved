package com.xzy.leetcode._1_300;

import com.xzy.common.TreeNode;

import java.util.*;

/**
 * User: RuzzZZ
 * Date: 2023/5/23
 * Time: 10:44
 */
public class Solution_297 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        treeNode3.right = treeNode4;
        treeNode4.right = treeNode5;
        treeNode5.right = treeNode6;
        treeNode6.right = treeNode7;
        Solution_297 solution297 = new Solution_297();
        String serialize = solution297.serialize(treeNode1);
        System.out.println(serialize);
        System.out.println(solution297.deserialize(serialize));
    }
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
