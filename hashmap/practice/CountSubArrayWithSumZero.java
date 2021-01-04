package hashmap.practice;

import java.util.*;

public class CountSubArrayWithSumZero
{
    private static int solve(int[] A) {
        int count = 0;
        for (int i=0;i<A.length;i++) {
            int sum = 0;
            for (int j=i;j<A.length;j++) {
                sum += A[j];
                if (sum == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int solve1(int[] A) {
        int count = 0;
        int[] prefix = new int[A.length];
        prefix[0] = A[0];
        for (int i=1;i<A.length;i++) {
            prefix[i] = prefix[i-1] + A[i];
        }
        for (int i=0;i<A.length;i++) {
            for (int j=i;j<A.length;j++) {
                if (i == 0) {
                    if (prefix[j] == 0) {
                        count++;
                    }
                } else if (prefix[j] == prefix[i-1]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int solve2(int[] A) {
        int count = 0, prefixSum = 0;
        // prefix sum with its frequency
        Map<Integer, Integer> map = new HashMap<>();
        // to handle the case when the current prefix sum is equal to 0
        map.put(0,1);
        for (int i=0;i<A.length;i++) {
            prefixSum += A[i];
            if (map.containsKey(prefixSum)) {
                count += map.get(prefixSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] A = {1, -1 ,2 , -2, 6, -6};
        System.out.println(solve2(A));
    }
}
