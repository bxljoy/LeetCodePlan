package com.alexbao.leetcode7;

import java.util.HashMap;

public class DecodeTheMessage {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        char base = 'a';
        int count = 0;
        for (char c : key.toCharArray()) {
            if (c != ' ' && !map.containsKey(c)) {
                map.put(c, base++);
                count ++;
            }
            if (count >= 26) {
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c != ' ') {
                c = map.get(c);
            }
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        DecodeTheMessage app = new DecodeTheMessage();
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(app.decodeMessage(key, message));
    }
}
