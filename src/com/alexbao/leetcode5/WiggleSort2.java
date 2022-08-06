package com.alexbao.leetcode5;

import java.util.Collections;
import java.util.PriorityQueue;

public class WiggleSort2 {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.offer(num);
        }

        for (int i=0; i<nums.length; i=i+2) {
            nums[i] = pq.poll();
        }

        for (int i=1; i<nums.length; i=i+2) {
            nums[i] = pq.poll();
        }
    }
}
