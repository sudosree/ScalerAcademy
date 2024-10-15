package queue.assignment;

import java.util.ArrayDeque;
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

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        for (int i=0; i<k; i++) {
            // if the current element is greater than the last element of the queue
            // then remove it as smaller elements will not contribute to max element
            // in the future windows
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.pollLast();
            }
            // add the element
            queue.offer(nums[i]);
        }
        // add the first element to the res array as it will always contain the
        // max element of the current window
        res[0] = queue.peek();
        for (int i=k; i<n; i++) {
            // check if the element that is removed from the window is the same as the
            // front element in the queue then remove it from the queue
            if (nums[i-k] == queue.peek()) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.offer(nums[i]);
            res[i-k+1] = queue.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int B = 1;
        System.out.println(Arrays.toString(slidingMaximum(A,B)));
    }
}
