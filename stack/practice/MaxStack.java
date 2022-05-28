package stack.practice;

import java.util.Stack;

public class MaxStack {
    // normal stack
    private Stack<Integer> stack1;
    // keep elements in ascending order
    private Stack<Integer> stack2;

    public MaxStack() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        int max = stack2.empty() ? x : stack2.peek();
        stack2.push(max > x ? max : x);
        stack1.push(x);

    }

    public int pop() {
        stack2.pop();
        return stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int peekMax() {
        return stack2.peek();
    }

    public int popMax() {
        if (stack2.empty()) {
            return -1;
        }
        int max = stack2.peek();
        int peek = top();
        Stack<Integer> buffer = new Stack<>();
        while (peek != max) {
            buffer.push(pop());
            peek = top();
        }
        pop();
        while (!buffer.empty()) {
            push(buffer.pop());
        }
        return max;
    }
}
