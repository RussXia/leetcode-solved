package com.xzy.algorithm.traversal;

import com.xzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-03-30
 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        List<Integer> list = new ArrayList<>();
        recurseFront(treeNode,list);
        System.out.println();
        System.out.println(list);
    }

    /**
     * 前序遍历 * * @param treeNode 需要遍历的二叉树
     */
    public static List<Integer> recurseFront(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null)
            return list;
        System.out.print(treeNode.val + "\t");
        list.add(treeNode.val);
        recurseFront(treeNode.left, list);
        recurseFront(treeNode.right, list);
        return list;
    }

}
