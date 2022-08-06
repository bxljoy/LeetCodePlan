package com.alexbao.leetcode3;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int res = 0;
        int sum = 0;

        while (right < nums.length) {
            int c = nums[right];
            right ++;
            sum += c;
            while (sum >= target) {
                if (res == 0) {
                    res = right - left;
                } else {
                    res = res < (right - left) ? res : (right - left);
                }
                int d = nums[left];
                left ++;
                sum -= d;
            }
        }

        return res;
    }
}
