package queue.assignment;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumSlidingWindow {

    public static int[] slidingMaximum(final int[] A, int B) {
        Deque<Integer> queue = new LinkedList<>();
        int n = A.length;
        // total there are n-B+1 windows
        int[] C = new int[n-B+1];
        for (int i=0;i<B;i++) {
            if (queue.isEmpty() || A[i] <= queue.peekLast()) {
                queue.offer(A[i]);
            } else {
                while (!queue.isEmpty() && A[i] > queue.peekLast()) {
                    queue.pollLast();
                }
                queue.offer(A[i]);
            }
        }
        int i=1;
        for (i=1;i<n-B+1;i++) {
            // the front of the queue is always the maximum element of a window of size B
            C[i-1] = queue.peek();
            // if the element that is removed from the window is same as the front then remove the front
            if (queue.peek() == A[i-1]) {
                queue.poll();
            }
            if (queue.isEmpty() || A[i+B-1] <= queue.peekLast()) {
                queue.offer(A[i+B-1]);
            } else {
                while (!queue.isEmpty() && A[i+B-1] > queue.peekLast()) {
                    queue.pollLast();
                }
                queue.offer(A[i+B-1]);
            }
        }
        C[i-1] = queue.peek();
        return C;
    }

    public static void main(String[] args) {
        int[] A = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int B = 1;
        System.out.println(Arrays.toString(slidingMaximum(A,B)));
    }
}
