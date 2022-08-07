package com.alexbao.leetcode7;

public class RecoverBinarySearchTree {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (root.val < pre.val) {
            if (first == null) {
                first = pre;
            }
            second = root;
        }
        pre = root;
        traverse(root.right);
    }
}
