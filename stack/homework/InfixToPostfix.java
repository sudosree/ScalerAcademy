package stack.homework;

import java.util.Stack;

public class InfixToPostfix {

    public String solve(String A) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<A.length();i++) {
            char c = A.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == '^' || c == '/' || c == '*' || c == '+' || c == '-') {
                if (stack.empty() || stack.peek() == '(') {
                    stack.push(c);
                } else {
                    while (!stack.empty() && prece(c) <= prece(stack.peek())) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            } else if (c == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private int prece(char ch) {
        switch(ch) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
