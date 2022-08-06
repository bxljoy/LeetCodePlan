package com.alexbao.leetcode5;

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        SortedSet<Integer> hashSet = new TreeSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int res = 0;
        int count = 1;
        int pre = -100000000;
        Iterator<Integer> it = hashSet.iterator();
        while (it.hasNext()) {
            int cur = it.next();
            System.out.println(cur);
            if (cur == pre+1) {
                count ++;
            } else {
                count = 1;
            }
            res = res > count ? res : count;
            pre = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        LongestConsecutiveSequence app = new LongestConsecutiveSequence();
        System.out.println(app.longestConsecutive(nums));
    }
}
