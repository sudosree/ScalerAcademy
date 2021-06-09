package queue.practice;

import java.util.Stack;

/**
 * Enqueue - O(n), Dequeue - O(1)
 */
public class QueueUsingStacks {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;

    public QueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        front = -1;
    }

    private void enqueue(int x) {
        if (s1.empty()) {
            front = x;
        }
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }

    private int dequeue() {
        int n = -1;
        if (!s1.empty()) {
            n = s1.pop();
        }
        if (!s1.empty()) {
            front = s1.peek();
        } else {
            front = -1;
        }
        return n;
    }

    private int front() {
        return front;
    }

    private boolean empty() {
        return s1.empty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.front());
        System.out.println(queue.empty());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.front());
        System.out.println(queue.empty());
        queue.enqueue(5);
        queue.dequeue();
        System.out.println(queue.front());
        System.out.println(queue.empty());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.front());
        System.out.println(queue.empty());
        System.out.println(queue.dequeue());
    }
}
