package com.alexbao.leetcode6;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class CompareStringsByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        int[] queryFrequency = new int[queries.length];
        Integer[] wordFrequency = new Integer[words.length];
        for (int i=0; i<queryFrequency.length; i++) {
            queryFrequency[i] = frequencyOfLexSmallestCharacter(queries[i]);
        }
        for (int i=0; i<wordFrequency.length; i++) {
            wordFrequency[i] = frequencyOfLexSmallestCharacter(words[i]);
        }
        Arrays.sort(wordFrequency, Collections.reverseOrder());
        for (int i=0; i<queryFrequency.length; i++) {
            int count = 0;
            for (int j=0; j<wordFrequency.length; j++) {
                if (queryFrequency[i] < wordFrequency[j]) {
                    count ++;
                } else {
                    break;
                }
            }
            res[i] = count;
        }
        return res;
    }

    int frequencyOfLexSmallestCharacter(String word) {
        int res = 0;
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            pq.offer(c);
        }
        char firstCharacter = pq.poll();
        res ++;
        while (!pq.isEmpty()) {
           char cur = pq.poll();
           if (cur == firstCharacter) {
               res ++;
           } else {
               break;
           }
        }
        return res;
    }

    public static void main(String[] args) {
        CompareStringsByFrequency app = new CompareStringsByFrequency();
        String s = "zaaaz";
        int count = app.frequencyOfLexSmallestCharacter(s);
        System.out.println(count);
    }
}
