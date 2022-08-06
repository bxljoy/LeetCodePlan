package com.alexbao.leetcode6;

import java.util.Arrays;
import java.util.Comparator;

public class TheNumberOfWeakCharacter {
    public int numberOfWeakCharacters(int[][] properties) {
        int res = 0;
        Arrays.sort(properties, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ?
                Integer.compare(o2[1], o1[1]) : Integer.compare(o1[0], o2[0]));
        int len = properties.length;
        int max = properties[len-1][1];
        for (int i=len-2; i>=0; i--) {
            if (properties[i][1] < max) {
                res ++;
            } else {
                max = properties[i][1];
            }
        }
        return res;
    }
}
