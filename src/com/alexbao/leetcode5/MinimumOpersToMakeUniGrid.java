package com.alexbao.leetcode5;

import java.util.ArrayList;
import java.util.Collections;

public class MinimumOpersToMakeUniGrid {
    public int minOperations(int[][] grid, int x) {
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<grid.length; i++)
            for (int j=0; j<grid[0].length; j++)
                list.add(grid[i][j]);
        Collections.sort(list);
        int middle = list.size() / 2;
        int diff = 0;
        for (int i=0; i<list.size(); i++) {
            if (i < middle) {
                diff = list.get(middle) - list.get(i);
            } else if (i > middle) {
                diff = list.get(i) - list.get(middle);
            } else {
                continue;
            }
            if (diff % x == 0) {
                res += diff / x;
            } else {
                return -1;
            }
        }
        return res;
    }
}
