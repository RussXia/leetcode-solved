package com.xzy.leetcode;

import com.xzy.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiazhengyue
 * @since 2021-03-17
 */
public class Solution_102 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);

        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(levelOrder(treeNode));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null){
            return levelOrder;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //每层遍历的结果和需要遍历的长度
            List<Integer> levelNode = new ArrayList<>();
            int size = queue.size();
            //取前n个元素，前n个元素是同一层的
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNode.add(node.val);
                //将当前节点的两个字节点压入队列尾部
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelOrder.add(levelNode);
        }
        return levelOrder;
    }

}
