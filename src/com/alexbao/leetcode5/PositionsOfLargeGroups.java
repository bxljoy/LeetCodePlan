package com.alexbao.leetcode5;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int left = 0;
        int right = 1;
        while (right < s.length()) {
            char lc = s.charAt(left);
            char lr = s.charAt(right);
            if (lc != lr) {
                if (right - left >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right - 1);
                    res.add(list);
                }
                left = right;
            }
            right ++;
        }
        if (right - left >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(left);
            list.add(right - 1);
            res.add(list);
        }
        return res;
    }
}
