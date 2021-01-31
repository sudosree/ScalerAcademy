package hashmap.practice;

import java.util.*;

public class SubarrayWithBOddNumbers
{
    public int solve(int[] A, int B) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        long prefix_sum = 0;
        int count = 0;
        for (int i=0;i<A.length;i++) {
            prefix_sum += (A[i]%2 == 1 ? 1 : 0);
            if (map.containsKey(prefix_sum - B)) {
                count += map.get(prefix_sum - B);
            }
            map.put(prefix_sum, map.getOrDefault(prefix_sum, 0) + 1);
        }
        return count;
    }
}
