package com.alexbao.leetcode4;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelTraverse {
    void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i=0; i<sz; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    }
}
