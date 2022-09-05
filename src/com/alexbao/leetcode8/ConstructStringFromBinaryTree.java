package com.alexbao.leetcode8;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) {
            return root.val + "";
        }

        String leftStr = tree2str(root.left);
        String rightStr = tree2str(root.right);
        if (root.left != null && root.right == null) {
            return root.val + "(" + leftStr + ")";
        }
        if (root.left == null && root.right != null) {
            return root.val + "()" + "(" + rightStr + ")";
        }
        return root.val + "(" + leftStr + ")" + "(" + rightStr + ")";
    }
}
