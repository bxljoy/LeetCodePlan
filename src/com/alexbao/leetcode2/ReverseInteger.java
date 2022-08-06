package com.alexbao.leetcode2;

public class ReverseInteger {
    public int reverse(int x) {
        char[] chs = String.valueOf(x).toCharArray();
        int left = 0;
        if (chs[0] == '-') {
            left ++;
        }
        int right = chs.length - 1;
        while (left < right) {
            char tmp = chs[left];
            chs[left] = chs[right];
            chs[right] = tmp;
            left ++;
            right --;
        }

        int res;

        try {
            res = Integer.valueOf(String.valueOf(chs));
        } catch (NumberFormatException e) {
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 1534236469;
        ReverseInteger app = new ReverseInteger();
        System.out.println(app.reverse(a));
    }
}
