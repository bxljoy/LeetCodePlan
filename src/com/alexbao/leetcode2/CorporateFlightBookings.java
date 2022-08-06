package com.alexbao.leetcode2;

public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference dif = new Difference(nums);
        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int val = booking[2];
            dif.increment(start-1, end-1, val);
        }
        return dif.result();
    }

}

