package com.xzy.leetcode;

import com.xzy.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-04-01
 */
public class Solution_513 {

    public static void main(String[] args) {

        Solution_513 solution = new Solution_513();

        {
            TreeNode treeNode = new TreeNode(1);
            treeNode.left = new TreeNode(2);
            treeNode.left.left = new TreeNode(4);

            treeNode.right = new TreeNode(3);
            treeNode.right.left = new TreeNode(5);
            treeNode.right.left.left = new TreeNode(7);
            treeNode.right.right = new TreeNode(6);

//            System.out.println(solution.findBottomLeftValue(treeNode));
        }

        {
            TreeNode treeNode = new TreeNode(0);
            treeNode.right = new TreeNode(-1);
            System.out.println(solution.findBottomLeftValue(treeNode));
        }

    }

    public int findBottomLeftValue(TreeNode root) {
        List<Integer> leftElement = new ArrayList<>();
        //层序遍历
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        leftElement.add(root.val);
        while(!queue.isEmpty()) {
            breadthTraversal(queue, leftElement);
        }
        return leftElement.get(leftElement.size() - 1);
    }

    private void breadthTraversal(Deque<TreeNode> queue, List<Integer> leftElement) {
        int size = queue.size();
        boolean leftAdded = false;
        for (int i = 0; i < size; i++) {
            TreeNode treeNode = queue.pollFirst();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
                if (!leftAdded) {
                    leftElement.add(treeNode.left.val);
                    leftAdded = true;
                }
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
                if (!leftAdded) {
                    leftElement.add(treeNode.right.val);
                    leftAdded = true;
                }
            }
        }
    }
}
