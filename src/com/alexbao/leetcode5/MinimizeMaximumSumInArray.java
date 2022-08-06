package com.alexbao.leetcode5;

import java.util.Arrays;

public class MinimizeMaximumSumInArray {
    public int minPairSum(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            res = res > sum ? res : sum;
            left ++;
            right --;
        }
        return res;
    }
}
