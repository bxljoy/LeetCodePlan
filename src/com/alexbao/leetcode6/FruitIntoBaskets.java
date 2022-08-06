package com.alexbao.leetcode6;

import java.util.HashMap;
import java.util.TreeMap;

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int res = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int left = 0;
        int right = 0;
        while (right < fruits.length) {
            int cur = fruits[right];
            if (!map.containsKey(cur)) {
                if (map.size() < 2) {
                    map.put(cur, right);
                } else {
                    map.remove(fruits[left]);
                    res = res > (right - left) ? res : (right - left);
                    left = map.firstEntry().getValue();
                    right = left;
                }
            }
            right ++;
        }
        res = res > (right - left) ? res : (right -left);
        return res;
    }
}
