package com.alexbao.leetcode3;

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < nums.length) {
            int c = nums[right];
            right ++;
            window.put(c, 1);

            System.out.println("left = " + left + ", right = " + right);
            System.out.println(window.size());

            if (window.size() == k) {
                res ++;
                System.out.println("res = " + res);
            }

            if (right == nums.length) {
                window.clear();
                System.out.println("window size = " + window.size());
                left ++;
                right = left;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,1,2,3};
        int k1 = 2;
        int[] nums2 = {1,2,1,3,4};
        int k2 = 3;
        int[] nums3 = {2,1,2,1,2};
        int k3 = 2;
        SubarraysWithKDifferentIntegers app = new SubarraysWithKDifferentIntegers();
        System.out.println(app.subarraysWithKDistinct(nums3, k3));
    }
}
