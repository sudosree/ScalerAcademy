package heap.practice;

import java.util.*;

public class ProductSort {

    private static Map<Integer, Integer> freq = new HashMap<>();

    private static int[] sort(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator());
        for (int num : freq.keySet()) {
            pq.offer(num);
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int num = pq.poll();
            ans.add(num);
        }
        int[] res = new int[ans.size()];
        for (int i=0; i< ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            // if the frequency of both the no.s are same then sort
            // it using their value
            if (freq.get(a) == freq.get(b)) {
                if (a == b) {
                    return 0;
                }
                return a < b ? -1 : 1;
            }
            return freq.get(a) < freq.get(b) ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {8,5,5,5,5,1,1,1,4,4};
        System.out.println(Arrays.toString(sort(nums)));
    }
}
