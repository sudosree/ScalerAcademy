package sorting.practice;

import java.util.*;

public class ProductSort {

    private static Map<Integer, Integer> map;

    private static int[] itemSort(int[] nums, int n) {
        map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new MyComparator());
        for (int i=0; i<n; i++) {
            pq.offer(nums[i]);
        }
        int[] ans = new int[n];
        int i=0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        return ans;
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (map.get(a) == map.get(b)) {
                if (a == b) {
                    return 0;
                }
                return a < b ? -1 : 1;
            }
            return map.get(a) < map.get(b) ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,5,4,3};
        int n = 6;
        System.out.println(Arrays.toString(itemSort(nums, 6)));
    }
}
