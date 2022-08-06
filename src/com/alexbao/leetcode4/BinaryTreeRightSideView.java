package com.alexbao.leetcode4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i=0; i<sz; i++) {
                TreeNode cur = queue.poll();
                if (i == sz - 1) {
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }

    List<Integer> res1 = new ArrayList<>();
    int depth = 0;
    public List<Integer> rightSideView2(TreeNode root) {
        traverse(root);
        return res1;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth ++;
        if (res1.size() < depth) {
            res1.add(root.val);
        }
        traverse(root.right);
        traverse(root.left);
        depth --;
    }
}
