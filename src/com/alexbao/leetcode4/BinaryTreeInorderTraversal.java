package com.alexbao.leetcode4;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }
}
