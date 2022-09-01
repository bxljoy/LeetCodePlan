package com.alexbao.leetcode8;

public class CountGoodNodesInBinaryTree {
    int res = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root, root.val);
        return res;
    }

    void traverse(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            res++;
            max = root.val;
        }
        traverse(root.left, max);
        traverse(root.right, max);
    }
}
