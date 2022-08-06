package com.alexbao.leetcode5;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        PriorityQueue<CharacterFrequency> queue = new PriorityQueue<>(s.length(), (o1, o2) -> {
            if (o1.getFrequency() > o2.getFrequency()) {
                return -1;
            } else if (o1.getFrequency() < o2.getFrequency()) {
                return 1;
            } else {
                return 0;
            }
        });
        HashMap<String, Integer> map = new HashMap<>();
        String[] chs = s.split("");
        for (String ch : chs) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String c = entry.getKey();
            int v = entry.getValue();
            CharacterFrequency cf = new CharacterFrequency(c, v);
            queue.offer(cf);
        }
        StringBuffer buffer = new StringBuffer();
        while (!queue.isEmpty()) {
            CharacterFrequency cf = queue.poll();
            String c = cf.getCharacter();
            int f = cf.getFrequency();
            while (f > 0) {
                buffer.append(c);
                f --;
            }
        }
        return buffer.toString();
    }
}

class CharacterFrequency {
    private String character;
    private int frequency;

    public CharacterFrequency() {
    }

    public CharacterFrequency(String character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public String getCharacter() {
        return this.character;
    }
    public void setCharacter(String character) {
        this.character = character;
    }

    public int getFrequency() {
        return this.frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
