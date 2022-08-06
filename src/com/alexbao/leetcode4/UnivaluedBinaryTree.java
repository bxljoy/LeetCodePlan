package com.alexbao.leetcode4;

public class UnivaluedBinaryTree {
    int preValue = 0;
    boolean res = true;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        preValue = root.val;
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val != preValue) {
            res = false;
        }
        traverse(root.left);
        traverse(root.right);
    }
}
