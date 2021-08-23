package stack.practice;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.empty() || stack2.peek() >= val) {
            stack2.push(val);
        }
    }

    public void pop() {
        if (stack1.empty()) {
            return;
        }
        int val = stack1.pop();
        if (!stack2.empty() && stack2.peek() == val) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.empty() ? -1 : stack1.peek();
    }

    public int getMin() {
        return stack2.empty() ? -1 : stack2.peek();
    }
}
