package com.alexbao.leetcode6;

import java.util.PriorityQueue;

public class KthSmallestProductOfTwoSortedArrays {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long res = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i=0; i<nums1.length; i++)
            for (int j=0; j<nums2.length; j++) {
                long product = nums1[i] * nums2[j];
                pq.offer(product);
            }
        while (!pq.isEmpty() && k > 0) {
            res = pq.poll();
            k --;
        }
        return res;
    }
}
