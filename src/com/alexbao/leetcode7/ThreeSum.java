package com.alexbao.leetcode7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            int target = 0 - nums[i];
            List<List<Integer>> pair = twoSum(nums, i + 1, target);
            for (int j=0; j<pair.size(); j++) {
                List<Integer> nodes = pair.get(j);
                nodes.add(nums[i]);
                res.add(nodes);
            }
            while (i < nums.length-1 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }

    List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start;
        int hi = nums.length - 1;
        while (lo < hi) {
            int left = nums[lo];
            int right = nums[hi];
            int sum = left + right;
            if (sum > target) {
                while (lo < hi && nums[hi] == right) hi--;
            } else if (sum < target) {
                while (lo < hi && nums[lo] == left) lo++;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                res.add(list);
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum app = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        app.threeSum(nums);
    }
}
