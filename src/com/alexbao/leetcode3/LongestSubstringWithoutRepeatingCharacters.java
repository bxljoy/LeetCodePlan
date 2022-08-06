package com.alexbao.leetcode3;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left ++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            res = res > right - left ? res : right - left;
        }

        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters app = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(app.lengthOfLongestSubstring("pwwkew"));
    }
}
