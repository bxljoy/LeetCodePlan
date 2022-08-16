package com.alexbao.leetcode7;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int res = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (value == 1) {
                res = Math.min(res, s.indexOf(key));
            }
        }
        if (res == Integer.MAX_VALUE) {
            res = -1;
        }
        return res;
    }
}
