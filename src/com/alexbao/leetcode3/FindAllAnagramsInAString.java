package com.alexbao.leetcode3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        char[] cp = p.toCharArray();
        for (char c : cp) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid ++;
                }
            }

            while (valid == need.size()) {
                if (right - left == p.length()) {
                    res.add(left);
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
        return res;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString app = new FindAllAnagramsInAString();
        app.findAnagrams("baa", "aa");
    }
}
