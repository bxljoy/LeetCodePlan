package com.alexbao.leetcode6;

import java.util.*;

public class FindModeInBST {
    HashMap<Integer, Integer> res = new HashMap<>();
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root);
        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            mapList.add(entry);
        }
        Collections.sort(mapList, (o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return -1;
            } else if (o1.getValue() < o2.getValue()) {
                return 1;
            } else {
                return 0;
            }
        });
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> map : mapList) {
            int key = map.getKey();
            int value = map.getValue();
            if (max == Integer.MIN_VALUE) {
                max = value;
                list.add(key);
                continue;
            }
            if (value == max) {
                list.add(key);
            } else {
                break;
            }
        }
        int[] arr = new int[list.size()];
        int i = 0;
        for (int val : list) {
            arr[i++] = val;
        }
        return arr;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        res.put(root.val, res.getOrDefault(root.val, 0) + 1);
        traverse(root.left);
        traverse(root.right);
    }
}
