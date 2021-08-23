package heap.practice;

import java.util.PriorityQueue;

public class KthLargestElement {

    /**
     * TC = O(k + (n-k) * logk)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i=0;i<k;i++) {
            pq.offer(nums[i]);
        }
        for (int i=k;i<nums.length;i++) {
            int val = pq.peek();
            if (val < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}
