package com.alexbao.leetcode;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                String s1 = s.substring(0, left) + s.substring(left+1, s.length());
                String s2 = s.substring(0, right) + s.substring(right+1, s.length());
                if (this.isPalindrome(s1) || this.isPalindrome(s2)) {
                    return true;
                } else {
                    return false;
                }
            }
            left ++;
            right --;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
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
}
