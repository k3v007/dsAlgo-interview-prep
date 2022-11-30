package org.example.dsAlgo.stacks;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> temp = new Stack<>();
        temp.push(s.charAt(0));
        for (int i = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!temp.isEmpty()) {
                if (isClosingBracket(temp, c)) {
                    temp.pop();
                } else {
                    temp.push(c);
                }
            } else {
                temp.push(c);
            }
        }
        return temp.isEmpty();
    }

    private boolean isClosingBracket(Stack<Character> temp, char c) {
        return (temp.peek() == '[' && c == ']')
                || (temp.peek() == '{' && c == '}')
                || (temp.peek() == '(' && c == ')');
    }
}
