package com.alexbao.leetcode7;

public class DIStringMatch {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] res = new int[n+1];
        int[] nums = new int[n+1];
        for (int i=0; i<n+1; i++) {
            nums[i] = i;
        }
        int left = 0;
        int right = n;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'I') {
                res[count++] = nums[left];
                left++;
            } else {
                res[count++] = nums[right];
                right--;
            }
        }
        res[count] = nums[left];
        return res;
    }
}
