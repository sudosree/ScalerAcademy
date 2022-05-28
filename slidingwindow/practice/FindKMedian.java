package slidingwindow.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKMedian {

    private static PriorityQueue<Integer> smallHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private static PriorityQueue<Integer> largeHeap = new PriorityQueue<>();

    /**
     * TC = O(klogk) + O((n-k) * logk) = O(nlogk)
     * SC = O(k) (for two heaps)
     * @param nums
     * @param k
     * @return
     */
    private static double[] findKMedian(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n-k+1];
        int j=0;
        // first add all the k elements of the first window
        for (int i=0; i<k; i++) {
            smallHeap.offer(nums[i]);
            rebalanceHeaps();
        }
        ans[j++] = findMedian();
        for (int i=1; i<n-k+1; i++) {
            // remove the (i-1)th element
            int elementToRemove = nums[i-1];
            if (elementToRemove <= smallHeap.peek()) {
                smallHeap.poll();
            } else {
                largeHeap.poll();
            }
            rebalanceHeaps();
            // add the (i+k-1)th element
            smallHeap.offer(nums[i+k-1]);
            rebalanceHeaps();
            ans[j++] = findMedian();
        }
        return ans;
    }

    private static void rebalanceHeaps() {
        if (smallHeap.size() > 0 && largeHeap.size() > 0 && smallHeap.peek() > largeHeap.peek()) {
            largeHeap.offer(smallHeap.poll());
        }
        if (smallHeap.size() > largeHeap.size() + 1) {
            largeHeap.offer(smallHeap.poll());
        } else if (largeHeap.size() > smallHeap.size() + 1) {
            smallHeap.offer(largeHeap.poll());
        }
    }

    private static double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        }
        return smallHeap.size() > largeHeap.size() ? smallHeap.peek() : largeHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -1, 3, 5};
        int k = 2;
        System.out.println(Arrays.toString(findKMedian(nums, k)));
    }
}
