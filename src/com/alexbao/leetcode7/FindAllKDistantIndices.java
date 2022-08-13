package com.alexbao.leetcode7;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndices {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int start = Math.max(i-k, 0);
            int end = Math.min(i+k, nums.length-1);
            for (int j=start; j<=end; j++) {
                if (nums[j] == key) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
