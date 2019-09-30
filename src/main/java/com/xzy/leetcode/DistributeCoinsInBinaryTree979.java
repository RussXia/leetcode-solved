package com.xzy.leetcode;

import com.xzy.common.TreeNode;

/**
 * @author xiazhengyue
 * @since 2019-01-24
 */
public class DistributeCoinsInBinaryTree979 {

    private static int moves = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(0);
        treeNode.left.right.right = new TreeNode(0);

        System.out.println(distributeCoins(treeNode));
    }

    public static int distributeCoins(TreeNode root) {
        int res = 0;
        if (root.left != null) {
            res += distributeCoins(root.left);
            //如果左子节点coin为0，从根节点下划一个给左子节点
            if (root.left.val == 0) {
                root.val += -1;
                res += 1;
            } else { //如果左子节点coin不为0(有可能是负的)，保证左子节点数量为1，不够从根节点划，多了上交到根节点
                root.val = root.val + root.left.val - 1;
                res += Math.abs(root.left.val - 1);
            }
        }
        if (root.right != null) {
            res += distributeCoins(root.right);
            //如果左子节点coin为0，从根节点下划一个给左子节点
            if (root.right.val == 0) {
                root.val += -1;
                res += 1;
            } else { //如果右子节点coin不为0(有可能是负的)，保证右子节点数量为1，不够从根节点划，多了上交到根节点
                root.val = root.val + root.right.val - 1;
                res += Math.abs(root.right.val - 1);
            }
        }
        return res;
    }
}
