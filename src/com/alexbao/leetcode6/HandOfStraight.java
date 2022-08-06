package com.alexbao.leetcode6;

import java.util.TreeMap;

public class HandOfStraight {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if (len % groupSize != 0) {
            return false;
        }
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int h : hand) {
            treeMap.put(h, treeMap.getOrDefault(h, 0)+1);
        }
        while (!treeMap.isEmpty()) {
            int first = treeMap.firstKey();
            int firstNum = treeMap.get(first);
            if (firstNum == 1) {
                treeMap.remove(first);
            } else {
                treeMap.put(first, firstNum-1);
            }
            for (int i=1; i<groupSize; i++) {
                int key = first + i;
                if (treeMap.containsKey(key)) {
                    int value = treeMap.get(key);
                    if (value == 1) {
                        treeMap.remove(key);
                    } else {
                        treeMap.put(key, value-1);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
