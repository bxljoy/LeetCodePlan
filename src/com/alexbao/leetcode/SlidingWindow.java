package com.alexbao.leetcode;

import java.util.HashMap;

public class SlidingWindow {
    /* 滑动窗口算法框架 */
    void slidingWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        char[] tc = t.toCharArray();
        for (char c : tc) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 增大窗口
            right++;
            // 进行窗口内数据的一系列更新
        //...

            /*** debug 输出的位置 ***/
            System.out.printf("window: [%d, %d)\n", left, right);
            /********************/

//            // 判断左侧窗口是否要收缩
//            while (window needs shrink) {
//                // d 是将移出窗口的字符
//                char d = s.charAt(left);
//                // 缩小窗口
//                left++;
//                // 进行窗口内数据的一系列更新
//            //...
//            }
        }
    }

}
