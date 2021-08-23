package stack.practice;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueueII {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    /** Initialize your data structure here. */
    public StackUsingQueueII() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
        this.top = -1;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // always add element to q2
        q2.offer(x);
        top = x;
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // remove element from q1
        int num = q1.poll();
        if (!q1.isEmpty()) {
            top = q1.peek();
        }
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
