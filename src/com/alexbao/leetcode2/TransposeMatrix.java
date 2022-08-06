package com.alexbao.leetcode2;

public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == cols) {
            for (int i=0; i<rows; i++)
                for (int j=i; j<cols; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            return matrix;
        } else {
            int[][] res = new int[cols][rows];
            for (int i=0; i<rows; i++)
                for (int j=0; j<cols; j++) {
                    res[j][i] = matrix[i][j];
                }
            return res;
        }
    }
}
