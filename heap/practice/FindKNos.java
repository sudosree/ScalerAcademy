package heap.practice;

import java.util.*;

public class FindKNos {

    private static int[] findKNos(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<n;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new MyComparator());
        int[] ans = new int[k];
        for (int i=0;i<k;i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }

    private static int[] findKNos1(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<n;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new MyComparator());

        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            pq.offer(mp);
        }

        int[] ans = new int[k];
        for (int i=0;i<k;i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }

    static class MyComparator implements Comparator<Map.Entry<Integer, Integer>> {

        @Override
        public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
            if (a.getValue() == b.getValue()) {
                if (b.getKey() < a.getKey()) {
                    return -1;
                }
                if (b.getKey() > a.getKey()) {
                    return 1;
                }
                return 0;
            }
            if (b.getValue() < a.getValue()) {
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int k = 4;
        System.out.println(Arrays.toString(findKNos(nums, k)));
        System.out.println(Arrays.toString(findKNos1(nums, k)));
    }
}
