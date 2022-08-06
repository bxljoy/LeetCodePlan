package com.alexbao.leetcode2;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int bigTo = 0;
        for (int[] trip : trips) {
            bigTo = bigTo > trip[2] ? bigTo : trip[2];
        }
        int [] nums = new int[bigTo];
        Difference dif = new Difference(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            int from = trip[1];
            int to = trip[2]-1;
            dif.increment(from, to, val);
        }

        int[] res = dif.result();
        for (int i=0; i<res.length; i++) {
            if (res[i] > capacity) {
                return false;
            }
        }

        return true;
    }
}
