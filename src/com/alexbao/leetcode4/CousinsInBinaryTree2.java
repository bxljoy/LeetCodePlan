package com.alexbao.leetcode4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CousinsInBinaryTree2 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Map<Integer, TreeNode>> res = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        Map<Integer, TreeNode> rootMap = new HashMap<>();
        rootMap.put(depth, null);
        res.put(root.val, rootMap);
        while (!queue.isEmpty()) {
            depth ++;
            int sz = queue.size();
            for (int i=0; i<sz; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    Map<Integer, TreeNode> leftMap = new HashMap<>();
                    leftMap.put(depth, cur);
                    res.put(cur.left.val, leftMap);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    Map<Integer, TreeNode> rightMap = new HashMap<>();
                    rightMap.put(depth, cur);
                    res.put(cur.right.val, rightMap);
                }
            }
        }
        int depthX = 0;
        int depthY = 0;
        TreeNode parentX = null;
        TreeNode parentY = null;
        for (Map.Entry<Integer, TreeNode> entry : res.get(x).entrySet()) {
            depthX = entry.getKey();
            parentX = entry.getValue();
        }
        for (Map.Entry<Integer, TreeNode> entry : res.get(y).entrySet()) {
            depthY = entry.getKey();
            parentY = entry.getValue();
        }
        if (depthX == depthY && parentX != parentY) {
            return true;
        }
        return false;
    }
}
