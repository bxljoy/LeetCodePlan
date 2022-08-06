package com.alexbao.leetcode;

public class ReverseString2 {
    public String reverseStr(String s, int k) {
        StringBuilder builder = new StringBuilder();
        while (s.length() - (k*2) > 0) {
            String left = s.substring(0, k);
            left = reverse(left);
            String right = s.substring(k, k*2);
            builder.append(left).append(right);
            s = s.substring(k*2);
        }
        if (s.length() < k) {
            builder.append(reverse(s));
        } else if (s.length() <= k*2 && s.length() >= k) {
            String left = s.substring(0, k);
            left = reverse(left);
            String right = s.substring(k);
            builder.append(left).append(right);
        }
        return builder.toString();
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

    public static void main(String[] args) {
        ReverseString2 r = new ReverseString2();
        String s = "abcdefg";
        System.out.println(r.reverseStr(s, 2));
    }
}
