package com.alexbao.leetcode2;

public class CountIntegersWithEvenDigitSum {
    public int countEven(int num) {
        int count = 0;
        for (int i=2; i<=num; i++) {
            if (i < 10) {
                if (i % 2 == 0)
                    count ++;
            } else {
                int digit = getDigit(i);
                if (digit % 2 == 0) {
                    count ++;
                }
            }
        }
        return count;
    }

    private int getDigit(int n) {
        if (n < 10) {
            return n;
        }
        return getDigit(n/10) + (n%10);
    }

    public static void main(String[] args) {

    }
}
