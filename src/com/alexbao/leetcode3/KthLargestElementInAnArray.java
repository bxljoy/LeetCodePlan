package com.alexbao.leetcode3;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0;
        for (int i=0; i<nums.length; i++) {
            pq.offer(nums[i]);
        }
        for (int j=0; j<k; j++) {
            res = pq.poll();
        }
        return res;
    }
}
