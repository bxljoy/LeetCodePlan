package com.alexbao.leetcode4;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        traverse(root.left);
        traverse(root.right);
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree1(root.left);
        TreeNode right = invertTree1(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
