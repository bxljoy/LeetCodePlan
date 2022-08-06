package com.alexbao.leetcode4;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        traverse(root);
        return res;
    }

    public void traverse(Node root) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            postorder(child);
        }
        res.add(root.val);
    }
}
