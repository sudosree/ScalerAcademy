package swiggy;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {

    public static int subarraysDivByK(int[] A, int K) {
        // map will store the mod values
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0, count = 0;
        for (int i=0;i<A.length;i++) {
            prefixSum += A[i];
            while (prefixSum < 0) {
                prefixSum = prefixSum + K;
            }
            int mod = prefixSum % K;
            if (map.containsKey(mod)) {
                count += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {0,5,3,8,2};
        System.out.println(subarraysDivByK(A, 3));
    }
}
