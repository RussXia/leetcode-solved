package com.xzy.leetcode._1201_;

import com.xzy.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiazhengyue
 * @since 2021-03-31
 */
public class Solution_1609 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(3);

        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(7);

        System.out.println(isEvenOddTree(treeNode));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(), preVal = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0){
                    if ( node.val % 2 == 0 || node.val <= preVal) return false;
                }else{
                    if ( node.val % 2 != 0 || node.val >= preVal) return false;
                }
                preVal = node.val;
                //添加子节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return true;
    }

}
