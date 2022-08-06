package com.alexbao.leetcode4;

public class DiameterOfBinaryTree {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int myDiameter = leftDepth + rightDepth;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
