package com.alexbao.leetcode7;

import java.util.HashMap;

public class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0);
            if (count > 0) {
                return c;
            } else {
                map.put(c, count + 1);
            }
        }
        return ' ';
    }
}
