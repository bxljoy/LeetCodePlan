package com.alexbao.leetcode3;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> res = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            res.offer(num);
        }
    }

    public int add(int val) {
        res.offer(val);
        while (res.size() > k) {
            res.poll();
        }
        return res.peek();
    }
}
