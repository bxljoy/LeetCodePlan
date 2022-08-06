package com.alexbao.leetcode2;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = 0;
        String[] res = s.split(" ");
        for (int i=res.length-1; i>=0; i--) {
            if (res[i] != "") {
                len = res[i].length();
                break;
            }
        }
        return len;
    }
}
