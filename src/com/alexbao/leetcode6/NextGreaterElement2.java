package com.alexbao.leetcode6;

import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i=2*len-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i%len]) {
                stack.pop();
            }
            res[i%len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%len]);
        }
        return res;
    }
}
