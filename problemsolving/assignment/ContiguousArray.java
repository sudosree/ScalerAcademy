package problemsolving.assignment;

import java.util.*;

public class ContiguousArray
{
    private static int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, prefixSum = 0;
        for (int i=0;i<A.length;i++) {
            prefixSum += A[i] == 0 ? -1 : 1;
            if (prefixSum == 0) {
                int currLen = i+1;
                maxLen = Math.max(maxLen, currLen);
            } else if (map.containsKey(prefixSum)) {
                int currLen = i - map.get(prefixSum);
                maxLen = Math.max(maxLen, currLen);
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args)
    {
        int[] A = {1, 1, 1, 0};
        System.out.println(solve(A));
    }
}
