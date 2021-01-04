package recursion.practice;

import java.util.*;

public class ValidParentheses
{
    private static boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<ch.length;i++) {
            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
                stack.push(ch[i]);
            } else {
                // this will happen when you are encountering ) or } or ] for the first time
                // and the stack is empty, this is not valid case
                if (stack.isEmpty()) {
                    return false;
                }
                Character c = stack.pop();
                // this will happen when the sequence is not correct
                if ((ch[i] == ')' && c != '(') || (ch[i] == '}' && c != '{')
                    || (ch[i] == ']' && c != '[')) {
                    return false;
                }
            }
        }
        // stack will become empty when there are equal no. of parentheses in the correct order
        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        String s = "])";
        System.out.println(isValid(s));
    }
}
