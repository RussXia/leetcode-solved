package com.xzy.leetcode._1_300;

import com.xzy.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_105 {

    private Map<Integer/*element*/, Integer/*index*/> indexMap;


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>(n);
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildMyTree(preorder, inorder, 0, preorder.length - 1,
                0, inorder.length - 1);
    }

    private TreeNode buildMyTree(int[] preorder, int[] inorder,
                                 int preorder_left, int preorder_right,
                                 int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right || inorder_left > inorder_right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preorder_left]);

        // 根据前序找到中序位置，中序左边为左子树，右边为右子树
        int index = indexMap.get(preorder[preorder_left]);
        // 左右子树的数组大小
        int left_sub_size = index - inorder_left;
        int right_sub_size = inorder_right - index;
        // 递归构建左子节点
        int preorder_left_start = preorder_left + 1;
        TreeNode leftTree = buildMyTree(preorder, inorder,
                preorder_left_start, preorder_left_start + left_sub_size - 1,
                inorder_left, index - 1);
        // 递归构建右子节点
        int preorder_right_start = preorder_left_start + left_sub_size;
        TreeNode rightTree = buildMyTree(preorder, inorder, preorder_right_start, preorder_right, index + 1, inorder_right);
        treeNode.left = leftTree;
        treeNode.right = rightTree;
        return treeNode;
    }


    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }


}
