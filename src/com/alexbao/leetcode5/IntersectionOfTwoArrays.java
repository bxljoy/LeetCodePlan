package com.alexbao.leetcode5;

import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        HashSet<Integer> set3;
        if (set1.size() >= set2.size()) {
            set3 = new HashSet<>(set1);
            set1.removeAll(set2);
            set3.removeAll(set1);
        } else {
            set3 = new HashSet<>(set2);
            set2.removeAll(set1);
            set3.removeAll(set2);
        }
        int[] res = new int[set3.size()];
        int i = 0;
        for (int element : set3) {
            res[i++] = element;
        }
        return res;
    }
}
