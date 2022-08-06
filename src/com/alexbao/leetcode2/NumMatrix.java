package com.alexbao.leetcode2;

public class NumMatrix {
    int[][] preSum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            return;
        }
        preSum = new int[m+1][n+1];
        for (int i=1; i<m+1; i++)
            for (int j=1; j<n+1; j++)
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + matrix[i-1][j-1];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row1][col2+1] - preSum[row2+1][col1] + preSum[row1][col1];
    }
}
