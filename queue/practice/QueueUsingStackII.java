package queue.practice;

import java.util.Stack;

/**
 * Enqueue - O(1), Dequeue - O(1) amortized
 */
public class QueueUsingStackII {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;

    public QueueUsingStackII() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        front = -1;
    }

    private void enqueue(int x) {
        if (s1.empty()) {
            front = x;
        }
        s1.push(x);
    }

    private int dequeue() {
        int n = -1;
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        if (!s2.empty()) {
            n = s2.pop();
        }
        if (!s2.empty()) {
            front = s2.peek();
        } else {
            front = -1;
        }
        return n;
    }

    private int front() {
        return front;
    }

    private boolean empty() {
        return s1.empty() && s2.empty();
    }

    public static void main(String[] args) {
        QueueUsingStackII queue = new QueueUsingStackII();
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
