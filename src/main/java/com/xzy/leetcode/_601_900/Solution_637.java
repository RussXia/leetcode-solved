package com.xzy.leetcode._601_900;

import com.xzy.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiazhengyue
 * @since 2021-03-17
 */
public class Solution_637 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2147483647);

        treeNode.left = new TreeNode(2147483647);
        treeNode.right = new TreeNode(2147483647);
        System.out.println(averageOfLevels(treeNode));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        //层序遍历每一层，求平均数
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            long sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(sum * 1.0 / size);
        }

        return result;
    }
}
