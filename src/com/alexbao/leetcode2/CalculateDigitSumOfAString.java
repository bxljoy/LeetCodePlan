package com.alexbao.leetcode2;

public class CalculateDigitSumOfAString {
    public String digitSum(String s, int k) {
        int len = s.length();
        if (len <= k) {
            return s;
        }
        StringBuilder digit = new StringBuilder();
        int t = len / k;
        for (int i=0; i<t; i++) {
            int sum = getDigitSum(s.substring(i*k, (i+1)*k));
            digit.append(sum);
        }
        String end = s.substring(t*k);
        if (end != "") {
            digit.append(getDigitSum(end));
        }

        return digitSum(digit.toString(), k);
    }

    private int getDigitSum(String str) {
        String[] digits = str.split("");
        int sum = 0;
        for (String s : digits) {
            sum += Integer.valueOf(s);
        }
        return sum;
    }

    private int getDigit(int num) {
        if (num < 10) {
            return num;
        }

        return getDigit(num / 10) + (num % 10);
    }

    public static void main(String[] args) {
        CalculateDigitSumOfAString app = new CalculateDigitSumOfAString();
        app.digitSum( "475730385258137", 13);
    }
}
