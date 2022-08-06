package com.alexbao.leetcode6;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }

        for (int i=0; i<n; i++) {
            if (res[i] > 0) {
                res[i] = res[i] - i;
            }
        }
        return res;
    }
}
