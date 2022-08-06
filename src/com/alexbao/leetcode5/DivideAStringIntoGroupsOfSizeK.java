package com.alexbao.leetcode5;

import java.util.ArrayList;

public class DivideAStringIntoGroupsOfSizeK {
    public String[] divideString(String s, int k, char fill) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (buffer.length() == k) {
                res.add(buffer.toString());
                buffer.delete(0, buffer.length());
                buffer.append(c);
            } else {
                buffer.append(c);
            }
        }
        if (buffer.length() > 0) {
            while (buffer.length() < k) {
                buffer.append(fill);
            }
            res.add(buffer.toString());
        }
        return res.toArray(new String[0]);
    }
}
