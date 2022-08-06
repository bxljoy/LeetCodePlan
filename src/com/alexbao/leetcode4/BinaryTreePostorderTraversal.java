package com.alexbao.leetcode4;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        traverse(root.right);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res1 = new ArrayList<>();
        if (root == null) {
            return res1;
        }

        res1.addAll(postorderTraversal1(root.left));
        res1.addAll(postorderTraversal1(root.right));
        res1.add(root.val);
        return res1;
    }
}
