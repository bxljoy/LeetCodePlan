package com.alexbao.leetcode6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KdiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        int res = 0;
        HashMap<Integer,Integer> numsMap = new HashMap<>();
        HashMap<Integer,Integer> resMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            numsMap.put(nums[i], numsMap.getOrDefault(nums[i],0)+1);
        }
        if (k == 0) {
            for (Map.Entry<Integer,Integer> entry : numsMap.entrySet()) {
                int value = entry.getValue();
                if (value > 1) {
                    res ++;
                }
            }
            return res;
        } else {
            for (int i=0; i<nums.length; i++) {
                int diff = nums[i] + k;
                if (!resMap.containsKey(nums[i]) && numsMap.containsKey(diff)) {
                    resMap.put(nums[i], 1);
                }
            }
            return resMap.size();
        }
    }
}
