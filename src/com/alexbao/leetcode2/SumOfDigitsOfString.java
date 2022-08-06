package com.alexbao.leetcode2;

public class SumOfDigitsOfString {
    public int getLucky(String s, int k) {
        String alphabet = "0abcdefghijklmnopqrstuvwxyz";
        String trans = "";
        char[] chs = s.toCharArray();
        int res = 0;
        for (char ch : chs) {
            res += getDigit(alphabet.indexOf(ch));
        }

        for (int i=0; i<k-1; i++) {
            res = getDigit(res);
        }

        return res;
    }

    private int getDigit(int n) {
        if (n < 10) {
            return n;
        }
        return getDigit(n/10) + (n%10);
    }

    public static void main(String[] args) {
        SumOfDigitsOfString sod = new SumOfDigitsOfString();
        System.out.println(sod.getLucky("iiii", 1));
    }
}
