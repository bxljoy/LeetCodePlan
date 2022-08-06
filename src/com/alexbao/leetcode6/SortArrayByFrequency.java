package com.alexbao.leetcode6;

import java.util.*;

public class SortArrayByFrequency {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return 1;
            } else if (o1.getValue() < o2.getValue()) {
                return -1;
            } else if (o1.getValue() == o2.getValue()) {
                if (o1.getKey() > o2.getKey()) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        });
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : list) {
            int key = entry.getKey();
            int value = entry.getValue();
            while (value > 0) {
                res.add(key);
                value --;
            }
        }
        int[] resArr = new int[res.size()];
        int i=0;
        for (int num : res) {
            resArr[i++] = num;
        }
        return resArr;
    }
}
