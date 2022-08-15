package com.alexbao.leetcode7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        boolean res = true;
        List<String> leftParentheses = new ArrayList<>();
        leftParentheses.add("(");
        leftParentheses.add("[");
        leftParentheses.add("{");
        List<String> rightParentheses = new ArrayList<>();
        rightParentheses.add(")");
        rightParentheses.add("]");
        rightParentheses.add("}");
        List<String> fullParentheses = new ArrayList<>();
        fullParentheses.add("()");
        fullParentheses.add("[]");
        fullParentheses.add("{}");
        Stack<String> stack = new Stack<>();
        String[] chs = s.split("");
        for (int i=0; i<chs.length; i++) {
            String ch = chs[i];
            if (leftParentheses.contains(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                String full = stack.pop() + ch;
                if (fullParentheses.contains(full)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && getMatch(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    char getMatch(char c) {
        if (c == ')') return '(';
        if (c == ']') return '[';
        return '{';
    }
}
