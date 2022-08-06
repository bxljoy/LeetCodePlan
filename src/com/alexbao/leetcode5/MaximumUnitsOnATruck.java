package com.alexbao.leetcode5;

import java.util.*;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        HashMap<Integer, Integer> unitsAndBoxes = new HashMap<>();
        for (int i=0; i<boxTypes.length; i++) {
            unitsAndBoxes.put(boxTypes[i][1],
                    unitsAndBoxes.getOrDefault(boxTypes[i][1], 0) + boxTypes[i][0]);
        }
        ArrayList<Integer> units = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : unitsAndBoxes.entrySet()) {
            units.add(entry.getKey());
        }
        Collections.sort(units, Collections.reverseOrder());
        int remain = truckSize;
        for (int i=0; i<units.size(); i++) {
            int unit = units.get(i);
            int boxes = unitsAndBoxes.get(unit);
            remain -= boxes;
            if (remain > 0) {
                res += unit * boxes;
            } else if (remain == 0) {
                res += unit * boxes;
                break;
            } else {
                res += unit * (boxes + remain);
                break;
            }
        }
        return res;
    }
}
