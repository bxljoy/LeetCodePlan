package com.alexbao.leetcode8;

import java.util.Iterator;
import java.util.Stack;

public class CheckIfWordIsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
            canPop(stack);
        }
        return stack.isEmpty();
    }

    void canPop(Stack<Character> stack) {
        if (stack.size() >= 3 && stack.peek().equals('c') ) {
            char c = stack.pop();
            if (stack.peek().equals('b')) {
                char b = stack.pop();
                if (stack.peek().equals('a')) {
                    stack.pop();
                } else {
                    stack.push(b);
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
    }

    public static void main(String[] args) {
        CheckIfWordIsValid app = new CheckIfWordIsValid();
        String s = "aabcbc";
        app.isValid(s);
    }
}
