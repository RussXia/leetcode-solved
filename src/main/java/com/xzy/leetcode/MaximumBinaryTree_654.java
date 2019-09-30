package com.xzy.leetcode;

import com.xzy.common.TreeNode;

/**
 * @author xiazhengyue
 * @since 2019-01-31
 */
public class MaximumBinaryTree_654 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode treeNode = constructMaximumBinaryTree(nums);
        System.out.println(treeNode);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursiveBinaryTree(nums, 0, nums.length - 1);
    }

    public static TreeNode recursiveBinaryTree(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int max = findMax(nums, start, end);
        TreeNode treeNode = new TreeNode(nums[max]);
        if (start != max) {
            treeNode.left = recursiveBinaryTree(nums, start, max - 1);
        }
        if (max != end) {
            treeNode.right = recursiveBinaryTree(nums, max + 1, end);
        }
        return treeNode;
    }

    public static int findMax(int[] nums, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        return max;
    }
}
