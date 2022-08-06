package com.alexbao.leetcode4;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public Node2 connect(Node2 root) {
        if (root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    public void traverse(Node2 node1, Node2 node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        traverse(node1.right, node2.left);
    }

    public Node2 connect2(Node2 root) {
        if (root == null) {
            return null;
        }
        Queue<Node2> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            Node2 middleNode = null;
            for (int i=0; i<sz; i++) {
                Node2 cur = queue.poll();
                if (middleNode == null) {
                    middleNode = cur.right;
                } else {
                    middleNode.next = cur.left;
                    middleNode = cur.right;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                    cur.left.next = cur.right;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }
}

/*
// Definition for a Node2.
*/
class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _left, Node2 _right, Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
