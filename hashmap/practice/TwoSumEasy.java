package hashmap.practice;

import java.util.HashMap;
import java.util.Map;

public class TwoSumEasy
{
    private static int[] twoSum(int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            if (!map.containsKey(B-A[i])) {
                map.put(A[i], i+1);
            } else {
                return new int[]{map.get(B-A[i]), i+1};
            }

        }
        return new int[]{};
    }
}
