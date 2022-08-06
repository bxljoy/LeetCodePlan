package com.alexbao.leetcode6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (String word2 : words2) {
            HashMap<Character, Integer> subFrequency = new HashMap<>();
            for (int i=0; i<word2.length(); i++) {
                char c = word2.charAt(i);
                subFrequency.put(c, subFrequency.getOrDefault(c, 0)+1);
            }
            for (Map.Entry<Character, Integer> entry : subFrequency.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                int maxVal = Math.max(value, frequency.getOrDefault(key, 0));
                frequency.put(key, maxVal);
            }
        }
        for (String word1 : words1) {
            HashMap<Character, Integer> subFrequency2 = new HashMap<>();
            for (int i=0; i<word1.length(); i++) {
                char c = word1.charAt(i);
                subFrequency2.put(c, subFrequency2.getOrDefault(c, 0)+1);
            }
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                if (!subFrequency2.containsKey(key)) {
                    flag = false;
                    break;
                } else {
                    if (subFrequency2.get(key) < value) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                res.add(word1);
            }
        }
        return res;
    }
}
