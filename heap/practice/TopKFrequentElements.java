package heap.practice;

import java.util.*;

public class TopKFrequentElements {

    /**
     * TC = O(n + n + klogn) = O(klogn) (where O(n) - hashing, O(n) - max heap, O(klogn) - pushing and popping k times)
     * SC = O(n + n) = O(n)
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // will store all the elements with their frequency from highest to lowest
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int num : map.keySet()) {
            maxHeap.offer(num);
        }
        int[] ans = new int[k];
        for (int i=0;i<k;i++) {
            ans[i] = maxHeap.poll();
        }
        return ans;
    }

    /**
     * TC = O(n + nlogk + klogk) = O(nlogk)
     * SC = O(n + k) = O(n)
     * @param nums
     * @param k
     * @return
     */
    private static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int num : map.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] ans = new int[k];
        for (int i=0;i<k;i++) {
            ans[i] = minHeap.poll();
        }
        return ans;
    }

    private static  Map<Integer, Integer> map;

    public static int[] topKFrequent2(int[] nums, int k) {
        map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator());
        for (int num : map.keySet()) {
            pq.offer(num);
        }
        int[] ans = new int[k];
        for (int i=0;i<k;i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }

    static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return map.get(o2) - map.get(o1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,3,3,4,1,1,1,1};
        int k = 3;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
        System.out.println(Arrays.toString(topKFrequent1(nums, k)));
        System.out.println(Arrays.toString(topKFrequent2(nums, k)));
    }
}
