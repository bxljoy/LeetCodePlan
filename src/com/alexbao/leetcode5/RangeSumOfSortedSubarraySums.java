package com.alexbao.leetcode5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeSumOfSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> sums = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += nums[j];
                sums.add(sum);
            }
        }
        Collections.sort(sums);
        double res = 0;
        for (int i=left - 1; i<right; i++) {
            res += sums.get(i);
        }
        return (int) (res % (Math.pow(10, 9) + 7));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int n = 4;
        int left = 1;
        int right = 5;
        RangeSumOfSortedSubarraySums app = new RangeSumOfSortedSubarraySums();
        System.out.println(app.rangeSum(nums, n, left, right));
    }
}
