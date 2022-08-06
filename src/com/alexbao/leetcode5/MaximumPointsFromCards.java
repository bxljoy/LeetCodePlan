package com.alexbao.leetcode5;

public class MaximumPointsFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int remain = n - k;
        int totalSum = sum(cardPoints, 0, n);
        int subarraySum = sum(cardPoints, 0, remain);
        int minSum = subarraySum;
        for (int i=n-k; i<n; i++) {
            subarraySum += cardPoints[i];
            subarraySum -= cardPoints[i - remain];
            minSum = minSum < subarraySum ? minSum : subarraySum;
        }
        return totalSum - minSum;
    }

    public int maxScore2(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int subarraySum = sum(cardPoints, 0, k);
        int maxSum = subarraySum;
        for (int i=0; i<k; i++) {
            subarraySum += cardPoints[n-1-i];
            subarraySum -= cardPoints[k-1-i];
            maxSum = maxSum > subarraySum ? maxSum : subarraySum;
        }
        return maxSum;
    }

    private int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i=start; i<end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
