package com.alexbao.leetcode8;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 1) {
                return key;
            }
        }
        return 0;
    }
}
