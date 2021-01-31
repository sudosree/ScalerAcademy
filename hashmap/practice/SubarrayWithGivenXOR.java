package hashmap.practice;

import java.util.*;

public class SubarrayWithGivenXOR
{
    public int solve(int[] A, int B) {
        Map<Long, Integer> prefix_xor_map = new HashMap<>();
        prefix_xor_map.put(0L,1);
        long prefix_xor = 0;
        int count = 0;
        for (int i=0;i<A.length;i++) {
            prefix_xor ^= A[i];
            if (prefix_xor_map.containsKey(prefix_xor ^ B)) {
                count += prefix_xor_map.get(prefix_xor ^ B);
            }
            prefix_xor_map.put(prefix_xor, prefix_xor_map.getOrDefault(prefix_xor, 0) + 1);
        }
        return count;
    }
}
