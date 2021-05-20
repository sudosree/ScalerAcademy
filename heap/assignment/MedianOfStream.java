package heap.assignment;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfStream {

    /**
     * TC = O(nlogn), SC = O(n)
     */
    public int[] solve(int[] A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MyComparator());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] C = new int[A.length];
        int median = 0;

        for (int i=0;i<A.length;i++) {
            // insert the element in either max heap or min heap
            if (maxHeap.size() > minHeap.size()) {
                // insert into max heap
                if (A[i] < median) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(A[i]);
                }
                // insert into min heap
                else {
                    minHeap.offer(A[i]);
                }
            } else if (minHeap.size() > maxHeap.size()) {
                // insert into min heap
                if (A[i] > median) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(A[i]);
                }
                // insert into max heap
                else {
                    maxHeap.offer(A[i]);
                }
            } else {
                if (A[i] < median) {
                    maxHeap.offer(A[i]);
                } else {
                    minHeap.offer(A[i]);
                }
            }

            // find the median
            if (maxHeap.size() == minHeap.size() || maxHeap.size() > minHeap.size()) {
                median = maxHeap.peek();
            } else {
                median = minHeap.peek();
            }
            C[i] = median;
        }
        return C;
    }

    static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {
            return b-a;
        }
    }
}
