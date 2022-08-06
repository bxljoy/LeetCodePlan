package com.alexbao.leetcode6;

import java.util.LinkedList;

public class Codec {
    StringBuilder builder = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        preorder(root);
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

    void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        builder.append(root.val).append(",");
        if (root.left == null) {
            builder.append("#").append(",");
        }
        if (root.right == null) {
            builder.append("#").append(",");
        }
        preorder(root.left);
        preorder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        LinkedList<String> nodes = new LinkedList<>();
        for (String node : data.split(",")) {
            nodes.addLast(node);
        }
        return buildTree(nodes);
    }

    TreeNode buildTree(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String first = nodes.removeFirst();
        if (first.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(first));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);

        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
