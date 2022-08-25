package com.alexbao.leetcode8;

import java.util.HashMap;
import java.util.Map;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(i+1, 0);
        }
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int[] res = new int[2];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (2 == value) {
                res[0] = key;
            }
            if (0 == value) {
                res[1] = key;
            }
        }
        return res;
    }
}
