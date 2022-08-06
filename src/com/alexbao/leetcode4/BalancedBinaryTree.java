package com.alexbao.leetcode4;

public class BalancedBinaryTree {
    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return balanced;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            balanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
