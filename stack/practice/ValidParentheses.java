package stack.practice;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty() && (c == ')' || c == ']' || c == '}')) {
                    return false;
                }
                char ch = stack.peek();
                if ((ch == '(' && c != ')') || (ch == '[' && c != ']') || (ch == '{' && c != '}')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
