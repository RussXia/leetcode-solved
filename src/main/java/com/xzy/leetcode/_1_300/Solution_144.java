package com.xzy.leetcode._1_300;

import com.xzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-03-17
 */
public class Solution_144 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(2);
        System.out.println(preorderTraversal(treeNode));

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> node = new ArrayList<>();
        preorderRecursive(root,node);
        return node;
    }

    private static void preorderRecursive(TreeNode root,List<Integer> node){
        if(root == null){
            return;
        }
        node.add(root.val);
        preorderRecursive(root.left,node);
        preorderRecursive(root.right,node);
    }
}
