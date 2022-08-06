package com.alexbao.leetcode5;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveMinimumAndMaximumFromArray {
    public int minimumDeletions(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int n = nums.length;
        for (int i=0; i<n; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        int minIndex = map.get(nums[0]);
        int maxIndex = map.get(nums[n-1]);
        int minDeletions = n + 1;
        if (maxIndex > minIndex) {
            int first = maxIndex + 1;
            minDeletions = minDeletions < first ? minDeletions : first;
            int second = n - minIndex;
            minDeletions = minDeletions < second ? minDeletions : second;
            int third = minIndex + 1 + n - maxIndex;
            minDeletions = minDeletions < third ? minDeletions : third;
        } else if (maxIndex < minIndex) {
            int first = minIndex + 1;
            minDeletions = minDeletions < first ? minDeletions : first;
            int second = n - maxIndex;
            minDeletions = minDeletions < second ? minDeletions : second;
            int third = maxIndex + 1 + n - minIndex;
            minDeletions = minDeletions < third ? minDeletions : third;
        } else if (maxIndex == minIndex) {
            minDeletions = 1;
        }
        return minDeletions;
    }
}
