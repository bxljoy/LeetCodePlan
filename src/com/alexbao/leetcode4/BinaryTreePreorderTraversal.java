package com.alexbao.leetcode4;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> res1 = new ArrayList<>();
        if (root == null) {
            return res1;
        }
        res1.add(root.val);
        res1.addAll(preorderTraversal2(root.left));
        res1.addAll(preorderTraversal2(root.right));
        return res1;
    }
}
