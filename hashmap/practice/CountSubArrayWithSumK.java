package hashmap.practice;

import java.util.*;

public class CountSubArrayWithSumK
{
    private static int solve(int[] A, int k) {
        int count = 0;
        for (int i=0;i<A.length;i++) {
            int sum = 0;
            for (int j=i;j<A.length;j++) {
                sum += A[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int solve1(int[] nums, int k) {
        // create a prefixsum array
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i=1;i<prefixSum.length;i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int count = 0;
        for (int i=0;i<nums.length;i++) {
            for (int j=i;j<nums.length;j++) {
                // edge case
                if (i == 0) {
                    if (prefixSum[j] == k) {
                        count++;
                    }
                } else {
                    int sum = prefixSum[j] - prefixSum[i-1];
                    if (sum == k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static int solve2(int[] A, int k) {
        int count = 0, prefixSum = 0;
        // prefix sum with its frequency
        Map<Integer, Integer> map = new HashMap<>();
        // to handle the case when the current prefix sum is equal to k
        map.put(0,1);
        for (int i=0;i<A.length;i++) {
            prefixSum += A[i];
            if (map.containsKey(prefixSum-k)) {
                count += map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] A = {3,4,7,-2,2,1,4,2};
        int k = 7;
        System.out.println(solve2(A,k));
    }
}
