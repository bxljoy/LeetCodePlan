package com.alexbao.leetcode8;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        String st = s + t;
        int res = 0;
        for (char c : st.toCharArray()) {
            res ^= c;
        }
        return (char)res;
    }

    public static void main(String[] args) {
        int a = 0;
        char b = 'a';
        char res = (char)(a ^ b);
        System.out.println(res);
    }
}
