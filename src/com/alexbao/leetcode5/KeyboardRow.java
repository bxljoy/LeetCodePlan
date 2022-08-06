package com.alexbao.leetcode5;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        for (String word : words) {
            String wordL = word.toLowerCase();
            boolean flag = true;
            String startRow = "";
            for (int i=0; i<wordL.length(); i++) {
                char c = wordL.charAt(i);
                if (i == 0) {
                    if (row1.indexOf(c) >= 0) {
                        startRow = row1;
                    } else if (row2.indexOf(c) >= 0) {
                        startRow = row2;
                    } else if (row3.indexOf(c) >= 0) {
                        startRow = row3;
                    }
                } else {
                    if (startRow.indexOf(c) < 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }
}
