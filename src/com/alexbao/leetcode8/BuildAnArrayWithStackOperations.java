package com.alexbao.leetcode8;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int pointer = 0;
        int num = 1;
        while (pointer < target.length) {
            res.add("Push");
            if (num == target[pointer]) {
                pointer++;
            } else {
                res.add("Pop");
            }
            num++;
        }
        return res;
    }
}