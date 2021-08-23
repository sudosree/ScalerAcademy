package heap.practice;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    private PriorityQueue<Integer> pq;
    private int capacity;

    public KthLargestElementInStream(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.capacity = k;
        for (int i=0;i<nums.length;i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (pq.size() < capacity) {
            pq.offer(val);
        } else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
