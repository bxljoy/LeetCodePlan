package com.alexbao.leetcode7;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, null);
        return sum;
    }

    void dfs(TreeNode root, TreeNode pre) {
        if (root == null) {
            return;
        }

        if (pre == null) {
            pre = root;
        } else {
            if (root.left == null && root.right == null && pre.left == root) {
                sum += root.val;
            }
            pre = root;
        }

        dfs(root.left, pre);
        dfs(root.right, pre);
    }
}
