package com.alexbao.leetcode3;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String dic : dictionary) {
            if (isInDictionary(s, dic)) {
                if (res.length() < dic.length()) {
                    res = dic;
                } else if (res.length() == dic.length()) {
                    res = compareLoxicOrder(res, dic);
                }
            }
        }
        return res;
    }

    private boolean isInDictionary(String s, String dic) {
        int fast = 0;
        int slow = 0;
        while (slow < dic.length() && fast < s.length()) {
            if (s.charAt(fast) == dic.charAt(slow)) {
                slow ++;
            }
            fast ++;
        }
        if (slow == dic.length()) {
            return true;
        } else {
            return false;
        }
    }

    private String compareLoxicOrder(String s1, String s2) {
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return s1;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return s2;
            }
        }
        return s1;
    }
}
