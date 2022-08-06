package com.alexbao.leetcode3;


import java.util.ArrayList;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> res = new ArrayList<>();
        int plus = 1;
        for (int i=digits.length-1; i>=0; i--) {
            digits[i] = digits[i] + plus;
            if (digits[i] == 10) {
                if (i == 0) {
                    res.add(0);
                    res.add(1);
                } else {
                    res.add(0);
                    plus = 1;
                }
            } else {
                res.add(digits[i]);
                plus = 0;
            }
        }
        int[] last = new int[res.size()];
        for (int i=0; i<last.length; i++) {
            last[i] = res.get(last.length - 1 - i);
        }
        return last;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        int[] nums1 = {9,8,7,6,5,4,3,2,1,0};
        PlusOne po = new PlusOne();
        int[] res = po.plusOne(nums1);
        for (int r : res) {
            System.out.println(r);
        }
    }
}
