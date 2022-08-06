package com.alexbao.leetcode2;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up_bound = 0;
        int low_bound = n - 1;
        int left_bound = 0;
        int right_bound = n - 1;
        int num = 1;

        while (num <= n * n) {
            if (up_bound <= low_bound) {
                for (int i=left_bound; i<=right_bound; i++) {
                    res[up_bound][i] = num ++;
                }
                up_bound ++;
            }

            if (left_bound <= right_bound) {
                for (int i=up_bound; i<=low_bound; i++) {
                    res[i][right_bound] = num ++;
                }
                right_bound --;
            }

            if (up_bound <= low_bound) {
                for (int i=right_bound; i>=left_bound; i--) {
                    res[low_bound][i] = num ++;
                }
                low_bound --;
            }

            if (left_bound <= right_bound) {
                for (int i=low_bound; i>=up_bound; i--) {
                    res[i][left_bound] = num ++;
                }
                left_bound ++;
            }
        }
        return res;
    }
}
