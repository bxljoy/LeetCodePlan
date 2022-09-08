package com.alexbao.leetcode8;

public class MinimumAbsoluteDifferenceInBST {
    int res = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        traverse(root.right);
    }
}
