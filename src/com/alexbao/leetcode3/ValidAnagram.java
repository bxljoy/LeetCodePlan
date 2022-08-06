package com.alexbao.leetcode3;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        char[] ct = t.toCharArray();
        for (char c : ct) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int point = 0;
        int valid = 0;
        while (point < s.length()) {
            char c = s.charAt(point);
            point ++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid ++;
                }
            }
        }

        if (valid == need.size()) {
            return true;
        } else {
            return false;
        }
    }
}
