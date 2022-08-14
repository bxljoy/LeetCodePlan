package com.alexbao.leetcode7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllLonelyNumbers {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        int slow = 0;
        int fast = 1;
        int pre = Integer.MIN_VALUE;
        while (fast < nums.length) {
            if (pre + 1 < nums[slow] && nums[slow] + 1 < nums[fast]) {
                res.add(nums[slow]);
                pre = nums[slow];
                slow = fast;
                fast++;
            } else {
                pre = nums[slow];
                slow = fast;
                fast ++;
            }
        }
        if (pre + 1 < nums[slow]) {
            res.add(nums[slow]);
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllLonelyNumbers app = new FindAllLonelyNumbers();
        int[] nums = {75,35,59,66,69,53,37,16,60,98,11,33,3,85,59,65,59,44,34,89,72,47};
        app.findLonely(nums);
    }
}
