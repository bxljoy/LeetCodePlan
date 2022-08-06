package com.alexbao.leetcode6;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorder {
    HashMap<Integer, Integer> valAndIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i=0; i<inorder.length; i++) {
            valAndIndex.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length-1,
                postorder, 0, postorder.length-1);
    }

    TreeNode build(int[] inorder, int inStart, int inEnd,
                   int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int index = valAndIndex.get(rootVal);
        int leftSize = index - inStart;
        root.left = build(inorder, inStart, index-1,
                postorder, postStart, postStart+leftSize-1);
        root.right = build(inorder, index+1, inEnd,
                postorder, postStart+leftSize, postEnd-1);
        return root;
    }
}
