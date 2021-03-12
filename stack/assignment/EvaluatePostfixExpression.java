package stack.assignment;

import java.util.Stack;

public class EvaluatePostfixExpression {

    public static int evalRPN(String[] A) {
        Stack<String> stack = new Stack<>();
        for (int i=0;i<A.length;i++) {
            String s = A[i];
            if (s == "+" || s == "-" || s == "*" || s == "/") {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                if (s == "+") {
                    stack.push(String.valueOf(a + b));
                } else if (s == "-") {
                    stack.push(String.valueOf(a - b));
                } else if (s == "*") {
                    stack.push(String.valueOf(a * b));
                } else {
                    stack.push(String.valueOf(a / b));
                }
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.peek());
    }

    public static void main(String[] args) {
        String[] A = {"2", "2", "/"};
        System.out.println(evalRPN(A));
    }
}
