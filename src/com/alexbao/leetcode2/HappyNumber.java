package com.alexbao.leetcode2;

import java.util.ArrayList;

public class HappyNumber {
    ArrayList<Integer> list = new ArrayList<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        while (n > 1) {
            if (list.contains(n)) {
                return false;
            }
            list.add(n);
            n = getHappy(n);
        }
        return true;
    }

    private int getHappy(int n) {
        String num = String.valueOf(n);
        char[] chs = num.toCharArray();
        int next = 0;
        for (char ch : chs) {
            int number = Character.digit(ch, 10);
            next += number * number;
        }
        return next;
    }

    private int getHappy1(int n) {
        return 0;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(19));
    }
}
