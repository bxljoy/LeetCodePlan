package com.alexbao.leetcode7;

import java.util.ArrayList;
import java.util.List;

public class TwoSumInputBST {
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int[] nums = new int[list.size()];
        for (int i=0; i<nums.length; i++) {
            nums[i] = list.get(i);
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] + nums[hi] > k) {
                hi--;
            } else if (nums[lo] + nums[hi] < k) {
                lo++;
            } else {
                return true;
            }
        }
        return false;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
