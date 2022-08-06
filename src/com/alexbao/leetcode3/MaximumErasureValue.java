package com.alexbao.leetcode3;

import java.util.HashMap;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = 0;
        while (right < nums.length) {
            int c = nums[right];
            sum += c;
            right ++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                int d = nums[left];
                sum -= d;
                left ++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }

            res = res > sum ? res : sum;
        }
        return res;
    }
}
