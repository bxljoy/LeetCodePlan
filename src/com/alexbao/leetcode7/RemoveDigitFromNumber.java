package com.alexbao.leetcode7;

public class RemoveDigitFromNumber {
    public String removeDigit(String number, char digit) {
        StringBuilder sb = new StringBuilder(number);
        String s = String.valueOf(Integer.MIN_VALUE);
        for(int i=0;i<number.length();i++) {
            if(number.charAt(i) == digit) {
                sb.deleteCharAt(i);
                if(sb.toString().compareTo(s) > 0) {
                    s = sb.toString();
                }
                sb.insert(i, number.charAt(i));
            }
        }
        return s;
    }
}
