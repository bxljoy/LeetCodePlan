package com.alexbao.leetcode6;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndPostorder {
    HashMap<Integer, Integer> valAndIndex = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i=0; i<postorder.length; i++) {
            valAndIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length-1,
                postorder, 0, postorder.length-1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int rootVal = preorder[preStart];
        int leftRootVal = preorder[preStart + 1];
        int postLeftEnd = valAndIndex.get(leftRootVal);
        int leftSize = postLeftEnd - postStart + 1;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart+1, preStart+leftSize,
                postorder, postStart, postLeftEnd);
        root.right = build(preorder, preStart+leftSize+1, preEnd,
                postorder, postLeftEnd+1, postEnd-1);
        return root;
    }
}
