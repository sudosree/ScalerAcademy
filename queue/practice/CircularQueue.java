package queue.practice;

public class CircularQueue {

    private int[] queue;
    private int front;	// to indicate the front element of the queue
    private int rear;	// to indicate the rear element of the queue
    private int count;	// no. of elements in the queue
    private int capacity;

    public CircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public boolean enQueue(int value) {
        // check if the queue is full or not
        // if the queue is not full then insert element into the queue
        if (!isFull()) {
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            count++;
            return true;
        }
        // if the queue is full
        return false;
    }

    public boolean deQueue() {
        // check if the queue is empty or not
        // if the queue is not empty then delete element from the queue
        if (!isEmpty()) {
            int val = queue[front];
            front = (front + 1) % capacity;
            count--;
            return true;
        }
        return false;
    }

    public int Front() {
        return count == 0 ? -1 : queue[front];
    }

    public int Rear() {
        return count == 0 ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
