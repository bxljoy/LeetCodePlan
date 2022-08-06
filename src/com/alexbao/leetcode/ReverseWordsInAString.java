package com.alexbao.leetcode;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            String wordRev = reverse(word);
            builder.append(wordRev).append(" ");
        }
        return builder.toString().trim();
    }

    private String reverse(String str) {
        char[] s = str.toCharArray();
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left ++;
            right --;
        }
        return String.valueOf(s);
    }
}
