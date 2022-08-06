package com.alexbao.leetcode5;

import java.util.*;

public class FindSubsequenceOfLengthKLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(i, nums[i]);
        }
        List<Map.Entry<Integer, Integer>> list1 = new ArrayList<>(map.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        List<Map.Entry<Integer, Integer>> list2 = new ArrayList<>();
        for (int i=0; i<k; i++) {
            list2.add(list1.get(i));
        }
        Collections.sort(list2, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getKey() > o2.getKey()) {
                    return 1;
                } else if (o1.getKey() < o2.getKey()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int[] res = new int[k];
        for (int i=0; i<k; i++) {
            res[i] = list2.get(i).getValue();
        }
        return res;
    }
}
