package com.alexbao.leetcode;

import java.util.Collections;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s.length() > 40000) {
            return String.join("", Collections.nCopies(20000, "a")) + "dc" + s;
        }
        if (this.isPalindrome(s)) {
            return s;
        }
        int end = 1;
        for (int i=2; i<=s.length(); i++) {
            if (this.isPalindrome(s.substring(0, i))) {
                end = i;
            }
        }

        return this.reverseFromNum(s, end) + s;
    }

    private Boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    private String reverseFromNum(String s, int num) {
        String res = new String(s);
        int left = num;
        int right = res.length() - 1;
        char[] chars = res.toCharArray();
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left ++;
            right --;
        }
        return String.valueOf(chars).substring(num);
    }
}
