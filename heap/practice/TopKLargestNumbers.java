package heap.practice;

import java.util.PriorityQueue;

public class TopKLargestNumbers {
    private int[] findKLargestNos(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // first add the k numbers into the min heap
        for (int i=0; i<k; i++) {
            minHeap.offer(nums[i]);
        }
        // for the remaining elements check if the no. is greater than the peek of the
        // min heap then remove the smallest element and add the new element else skip the
        // new element
        for (int i=k; i<nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        int[] ans = new int[k];
        int i=0;
        while (!minHeap.isEmpty()) {
            ans[i++] = minHeap.poll();
        }
        return ans;
    }
}
