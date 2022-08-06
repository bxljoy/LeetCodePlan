package com.alexbao.leetcode4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<sz; i++) {
                Node cur = queue.poll();
                if (cur != null) {
                    list.add(cur.val);
                    if (cur.children != null) {
                        for (Node child : cur.children) {
                            queue.offer(child);
                        }
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
