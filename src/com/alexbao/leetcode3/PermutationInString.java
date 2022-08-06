package com.alexbao.leetcode3;

import java.util.HashMap;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        char[] ct = s1.toCharArray();
        for (char c : ct)
            need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int valid = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right ++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid ++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char d = s2.charAt(left);
                left ++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid --;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInString app = new PermutationInString();
        System.out.println(app.checkInclusion("ab", "eidbaooo"));
    }
}
