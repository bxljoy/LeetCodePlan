package com.alexbao.leetcode5;

import java.util.Arrays;
import java.util.Comparator;

public class FindTheKthLargestIntegerInArray {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        return nums[nums.length - k];
    }
}
