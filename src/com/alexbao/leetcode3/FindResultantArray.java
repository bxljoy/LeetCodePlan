package com.alexbao.leetcode3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindResultantArray {
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        for (String s : words) {
            res.add(s);
        }

        for (int i=1; i<words.length; i++) {
            if (isAnagram(words[i-1], words[i])) {
                res.remove(words[i]);
            }
        }

        return res;
    }

    private boolean isAnagram(String s, String t) {
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
