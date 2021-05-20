package heap.assignment;

import java.util.PriorityQueue;

public class AthLargestElement {

    /**
     * TC = O(nlogk), SC = O(k)
     */
    public int[] solve(int A, int[] B) {
        int[] ans = new int[B.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0;i<B.length;i++) {
            minHeap.offer(B[i]);
            int size = minHeap.size();
            if (size < A) {
                ans[i] = -1;
            } else if (size == A) {
                ans[i] = minHeap.peek();
            } else {
                minHeap.poll();
                ans[i] = minHeap.peek();
            }
        }
        return ans;
    }

    /**
     * TC = O(A + nlogA) = O(nlogA), SC = O(A)
     */
    public int[] solve1(int A, int[] B) {
        int[] ans = new int[B.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0;i<A;i++) {
            minHeap.offer(B[i]);
            if (i < A-1) {
                ans[i] = -1;
            } else {
                ans[i] = minHeap.peek();
            }
        }
        for (int i=A;i<B.length;i++) {
            if (B[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(B[i]);
            }
            ans[i] = minHeap.peek();
        }
        return ans;
    }
}
