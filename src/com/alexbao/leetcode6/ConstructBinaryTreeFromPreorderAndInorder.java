package com.alexbao.leetcode6;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorder {
    HashMap<Integer, Integer> valAndIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0; i<inorder.length; i++) {
            valAndIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = valAndIndex.get(rootVal);
        int leftSize = index - inStart;
        root.left = build(preorder,preStart+1, preStart+leftSize,
                inorder, inStart, index-1);
        root.right = build(preorder, preStart+leftSize+1, preEnd,
                inorder, index+1, inEnd);
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
