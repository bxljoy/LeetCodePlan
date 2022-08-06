package com.alexbao.leetcode2;

public class UglyNumber {
    public boolean isUgly(int n) {
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }
        return true;
    }

    public int nthUglyNumber(int n) {
        int count = 1;
        int m = 1;
        while (count < n) {
            m += 1;
            if (isUgly(m))
                count ++;
        }

        return m;
    }

}
