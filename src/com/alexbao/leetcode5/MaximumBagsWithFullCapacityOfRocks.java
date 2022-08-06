package com.alexbao.leetcode5;

import java.util.Arrays;

public class MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int res = 0;
        int[] diff = new int[capacity.length];
        for (int i=0; i<capacity.length; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        for (int i=0; i<diff.length; i++) {
            additionalRocks -= diff[i];
            if (additionalRocks > 0) {
                res ++;
            } else if (additionalRocks == 0) {
                res ++;
                break;
            } else {
                break;
            }
        }
        return res;
    }
}
