package com.alexbao.leetcode2;

import java.util.Arrays;

public class MinimumSumOfFourDigit {
    public int minimumSum(int num) {
        int[] digits = getDigits(num);
        return (digits[0] + digits[1]) * 10 + digits[2] + digits[3];
    }

    private int[] getDigits(int num) {
        int[] res = new int[4];
        for (int i=0; i<4; i++) {
            res[i] = num % 10;
            num = num / 10;
        }
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
        MinimumSumOfFourDigit app = new MinimumSumOfFourDigit();
        System.out.println(app.minimumSum(2932));
    }
}
