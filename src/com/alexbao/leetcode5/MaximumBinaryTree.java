package com.alexbao.leetcode5;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int maxVal = 0;
        int indexMaxVal = 0;
        for (int i=0; i<nums.length; i++) {
            if (maxVal < nums[i]) {
                maxVal = nums[i];
                indexMaxVal = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        int[] numsLeft = new int[indexMaxVal];
        for (int i=0; i<numsLeft.length; i++) {
            numsLeft[i] = nums[i];
        }
        int[] numsRight = new int[nums.length - indexMaxVal - 1];
        for (int i=0; i<numsRight.length; i++) {
            numsRight[i] = nums[indexMaxVal + 1 + i];
        }
        root.left = constructMaximumBinaryTree(numsLeft);
        root.right = constructMaximumBinaryTree(numsRight);
        return root;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}