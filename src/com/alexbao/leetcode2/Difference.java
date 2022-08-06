package com.alexbao.leetcode2;

public class Difference {
    private int[] diff;

    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i=1; i<diff.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }

    public void increment(int start, int end, int val) {
        diff[start] += val;
        if (end + 1 < diff.length) {
            diff[end + 1] -= val;
        }
    }

    public int[] result() {
        int [] res = new int[diff.length];
        res[0] = diff[0];
        for (int i=1; i<res.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

}

class Solution {
    public int[] updateNums(int len, int[][] updates) {
        int[] nums = new int[len];
        Difference dif = new Difference(nums);
        for (int i=0; i<updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            dif.increment(start, end, val);
        }
        return dif.result();
    }

    public static void main(String[] args) {
        int len = 5;
        int [][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        Solution solution = new Solution();
        int[] res = solution.updateNums(len, updates);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
