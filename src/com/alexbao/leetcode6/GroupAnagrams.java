package com.alexbao.leetcode6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> codeToGroup = new HashMap<>();
        for (String s : strs) {
            String code = encode(s);
            codeToGroup.putIfAbsent(code, new ArrayList<>());
            codeToGroup.get(code).add(s);
        }

        for (List<String> list : codeToGroup.values()) {
            res.add(list);
        }
        return res;
    }

    String encode(String s) {
        char[] count = new char[26];
        for (char c: s.toCharArray()) {
            int alphabet = c - 'a';
            count[alphabet] ++;
        }
        return new String(count);
    }
}
