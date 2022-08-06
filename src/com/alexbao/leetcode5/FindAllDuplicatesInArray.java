package com.alexbao.leetcode5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> frequent = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            frequent.put(nums[i], frequent.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : frequent.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 2) {
                res.add(key);
            }
        }
        return res;
    }
}
