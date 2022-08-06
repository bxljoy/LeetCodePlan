package com.alexbao.leetcode;

import java.util.Hashtable;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] outPut = new int[2];
        Hashtable<Integer, Integer> table = new Hashtable<>();
        for (int i=0; i<nums.length; i++) {
            table.put(nums[i], i);
        }

        for (int j=0; j<nums.length; j++) {
            int res = target - nums[j];
            if(isExistInArray(nums, res)) {
                outPut[0] = j;
                outPut[1] = table.get(res);
                return outPut;
            }
        }

        return outPut;
    }

    public boolean isExistInArray(int[] nums, int target) {
        boolean result = false;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == target) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = obj.twoSum(nums, target);
        for (int i=0; i<res.length; i++){
            System.out.println(res[i]);
        }
    }
}
