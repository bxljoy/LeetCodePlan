package com.alexbao.leetcode2;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        char[] ct = t.toCharArray();
        for (char c : ct) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int start = 0, len = Integer.MAX_VALUE;
        int valid = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid ++;
                }
            }

            /*** debug 输出的位置 ***/
            System.out.printf("window: [%d, %d)\n", left, right);
            /********************/

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left ++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid --;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }

            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        String s = mws.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
