package com.alexbao.leetcode4;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        traverse(root);
        return res;
    }

    public void traverse(Node root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        for (Node child : root.children) {
            traverse(child);
        }
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> res1 = new ArrayList<>();
        if (root == null) {
            return res1;
        }
        res1.add(root.val);
        for(Node child : root.children) {
            res1.addAll(preorder1(child));
        }
        return res1;
    }
}
