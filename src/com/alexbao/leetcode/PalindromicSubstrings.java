package com.alexbao.leetcode;

import java.util.ArrayList;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = s.length();
        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<s.length(); i++)
            for (int j=i+1; j<s.length(); j++) {
                String tmp = s.substring(i, j+1);
                if (list.contains(tmp)) {
                    count ++;
                    continue;
                }
                if (this.isPalindrome(tmp)) {
                    count ++;
                }
            }
        return count;
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
}
