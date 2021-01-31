package hashmap.practice;

import java.util.*;

public class LongestSubarrayLength
{
    public int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefix_sum = 0, max_len = 0, curr_len = 0;
        for (int i=0;i<A.length;i++) {
            prefix_sum += (A[i] == 1 ? 1 : -1);
            // the subarray has no. of 1s 1 more than no. of 0s starting from the 0th index
            if (prefix_sum == 1) {
                curr_len = i+1;
                max_len = Math.max(max_len, curr_len);
            } else if (!map.containsKey(prefix_sum)) {
                map.put(prefix_sum, i);
            }
            if (map.containsKey(prefix_sum - 1)) {
                curr_len = i - map.get(prefix_sum - 1);
                max_len = Math.max(max_len, curr_len);
            }
        }
        return max_len;
    }
}
