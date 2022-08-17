package com.alexbao.leetcode7;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morses = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<Character, String> alphaToMorse = new HashMap<>();
        char base = 'a';
        for (String morse : morses) {
            alphaToMorse.put(base++, morse);
        }
        HashSet<String> res = new HashSet<>();
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (char c : word.toCharArray()) {
                builder.append(alphaToMorse.get(c));
            }
            res.add(builder.toString());
        }
        return res.size();
    }
}
