package com.alexbao.leetcode;

import java.util.ArrayList;

public class TwoSum2 {
    public int[] twoSum1(int[] numbers, int target) {
        int[] output = new int[2];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<numbers.length; i++) {
            if (list.contains(numbers[i])) {
                continue;
            }
            int res = target - numbers[i];
            int count = getCount(numbers, res);
            if (count > -1) {
                output[0] = i+1;
                output[1] = count + 1;
                if (i == count) {
                    numbers[i] += 1;
                    count = getCount(numbers, res);
                    output[1] = count + 1;
                }
                break;
            } else {
                list.add(numbers[i]);
            }
        }
        return output;
    }

    private int getCount(int[] numbers, int num) {
        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left ++;
            } else if (sum == target) {
                output[0] = left + 1;
                output[1] = right + 1;
                break;
            } else {
                right --;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 0, 3, 4};
        int target = 0;
        TwoSum2 t = new TwoSum2();
        int[] output = t.twoSum1(numbers, target);
    }
}
