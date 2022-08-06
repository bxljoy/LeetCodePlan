package com.alexbao.leetcode4;

import java.util.List;

public class MaximumDepthOfNaryTree {
    int res = 0;
    int depth = 0;

    public int maxDepth(Node root) {
        traverse(root);
        return res;
    }

    public void traverse(Node root) {
        if (root == null) {
            return;
        }

        depth ++;
        res = Math.max(res, depth);
        for (Node child : root.children) {
            traverse(child);
        }
        depth --;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}