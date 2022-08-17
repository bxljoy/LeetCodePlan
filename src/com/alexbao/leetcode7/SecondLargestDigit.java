package com.alexbao.leetcode7;

import java.util.TreeSet;

public class SecondLargestDigit {
    public int secondHighest(String s) {
        TreeSet<Integer> set = new TreeSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int num = Character.getNumericValue(c);
                set.add(num);
            }
        }

        if (set.size() < 2) {
            return -1;
        } else {
            set.pollLast();
            return set.pollLast();
        }
    }
}