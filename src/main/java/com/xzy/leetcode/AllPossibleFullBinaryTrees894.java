package com.xzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2019-01-31
 */
public class AllPossibleFullBinaryTrees894 {

    public static void main(String[] args) {
        List<TreeNode> treeNodeList = allPossibleFBT(5);
        System.out.println(treeNodeList);
    }

    public static List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if (N % 2 == 0) {
            return treeNodeList;
        }
        if (N == 1) {
            treeNodeList.add(new TreeNode(0));
            return treeNodeList;
        }
        for (int i = 1; i < N - 1; i += 2) {
            List<TreeNode> leftTreeNodeList = allPossibleFBT(i);
            List<TreeNode> rightTreeNodeList = allPossibleFBT(N - i - 1);
            for (TreeNode left : leftTreeNodeList) {
                for (TreeNode right : rightTreeNodeList) {
                    TreeNode treeNode = new TreeNode(0);
                    treeNode.left = left;
                    treeNode.right = right;
                    treeNodeList.add(treeNode);
                }
            }
        }
        return treeNodeList;
    }

}
