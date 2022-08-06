package com.alexbao.leetcode3;

import java.util.HashMap;

public class MinimumConsecutiveCards {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = -1;

        while (right < cards.length) {
            int c = cards[right];
            right ++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                if (res > -1) {
                    res = res < (right - left) ? res : (right - left);
                } else {
                    res = right - left;
                }

                int d = cards[left];
                left ++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
        }

        return res;
    }
}
