package com.alexbao.leetcode3;

public class NumbersOfPairsOfStrings {
    public int numOfPairs(String[] nums, String target) {
        int count = 0;
        for (int i=0; i<nums.length; i++)
            for (int j=0; j<nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (target.equals((nums[i] + nums[j]))) {
                    count ++;
                }
            }
        return count;
    }

    public static void main(String[] args) {
        NumbersOfPairsOfStrings app = new NumbersOfPairsOfStrings();
    }
}
