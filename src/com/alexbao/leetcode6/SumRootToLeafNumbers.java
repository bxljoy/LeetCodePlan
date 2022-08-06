package com.alexbao.leetcode6;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
    List<String> res = new ArrayList<>();
    StringBuffer buffer = new StringBuffer();
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        traverse(root);
        for (String s : res) {
            sum += Integer.valueOf(s);
        }
        return sum;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        buffer.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(buffer.toString());
        }
        traverse(root.left);
        traverse(root.right);
        buffer.deleteCharAt(buffer.length()-1);
    }

    public static void main(String[] args) {
        String s = "049";
        int i = Integer.valueOf(s);
        System.out.println(i);
    }
}
