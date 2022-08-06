package com.alexbao.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int up_bound = 0;
        int low_bound = m - 1;
        int left_bound = 0;
        int right_bound = n - 1;
        ArrayList<Integer> res = new ArrayList<>();

        while (res.size() < (m * n)) {
            if (up_bound <= low_bound) {
                for (int i=left_bound; i<=right_bound; i++) {
                    res.add(matrix[up_bound][i]);
                }
                up_bound ++;
            }

            if (left_bound <= right_bound) {
                for (int i=up_bound; i<=low_bound; i++) {
                    res.add(matrix[i][right_bound]);
                }
                right_bound --;
            }

            if (up_bound <= low_bound) {
                for (int i=right_bound; i>=left_bound; i--) {
                    res.add(matrix[low_bound][i]);
                }
                low_bound --;
            }

            if (left_bound <= right_bound) {
                for (int i=low_bound; i>=up_bound; i--) {
                    res.add(matrix[i][left_bound]);
                }
                left_bound ++;
            }
        }
        return res;
    }
}
