package com.alexbao.leetcode2;

public class AddDigits {
    public int addDigits(int num) {
        while (num >= 10) {
            num = getDigit(num);
        }
        return num;
    }

    private int getDigit(int n) {
        if (n < 10) {
            return n;
        }
        return getDigit(n/10) + (n%10);
    }

    private int getDigit1(int n) {
        String[] digits = String.valueOf(n).split("");
        int sum = 0;
        for (String s : digits) {
            sum += Integer.valueOf(s);
        }
        return sum;
    }

    private int getDigit2(int n) {
        String num = String.valueOf(n);
        char[] chs = num.toCharArray();
        int sum = 0;
        for (char ch : chs) {
            int number = Character.digit(ch, 10);
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
        AddDigits ad = new AddDigits();
//        System.out.println(ad.getDigit(30000));
        int res = ad.addDigits(38);
        System.out.println(res);
    }
}
