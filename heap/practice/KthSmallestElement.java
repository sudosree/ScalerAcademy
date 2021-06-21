package heap.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {

    /**
     * TC = O(k + (n-k)logk), SC = O(k) using Max Heap
     * TC = O(n + klogn), SC = O(n) using Min Heap
     * @param A
     * @param k
     * @return
     */
    private static int findKthSmallestElement(int[] A, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MyComparator());
        // create a max heap of size k
        for (int i=0;i<k;i++) {
            maxHeap.offer(A[i]);
        }
        // for the remaining elements
        for (int i=k;i<A.length;i++) {
            int top = maxHeap.peek();
            if (A[i] < top) {
                // remove the top element
                maxHeap.poll();
                // insert A[i] into the max heap
                maxHeap.offer(A[i]);
            }
        }
        return maxHeap.peek();
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 == o1) {
                return 0;
            }
            return o2 < o1 ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        int[] A = {7, 10, 4, 3, 20, 15};
        int k = 4;
        System.out.println(findKthSmallestElement(A, k));
    }
}
