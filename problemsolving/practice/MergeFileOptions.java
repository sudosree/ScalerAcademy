package problemsolving.practice;

import java.util.PriorityQueue;

public class MergeFileOptions {

    private static int mergeFiles(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int i=0;i<nums.length;i++) {
            pq.offer(nums[i]);
        }
        while (pq.size() > 1) {
            int f1 = pq.poll();
            int f2 = pq.poll();
            int f3 = f1 + f2;
            pq.offer(f3);
            count += f3;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        System.out.println(mergeFiles(nums));
    }
}
