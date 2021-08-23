package stack.practice;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    /** Initialize your data structure here. */
    public StackUsingQueue() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
        this.top = -1;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // always add element to q1
        q1.offer(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // remove element from q1
        while (q1.size() > 1) {
            top = q1.poll();
            q2.offer(top);
        }
        int num = q1.poll();
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
        return num;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
