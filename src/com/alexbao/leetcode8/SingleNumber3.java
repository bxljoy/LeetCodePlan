package com.alexbao.leetcode8;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int count = 0;
        int[] res = new int[2];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 1) {
                res[count++] = key;
            }
        }
        return res;
    }
}
