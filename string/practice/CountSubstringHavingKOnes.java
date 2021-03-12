package string.practice;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringHavingKOnes {

    private static int countSetBits(String S, int K) {
        int count = 0;
        for (int i=0;i<S.length();i++) {
            int set_bits = 0;
            for (int j=i;j<S.length();j++) {
                if (S.charAt(j) == '1') {
                    set_bits++;
                }
                if (set_bits == K) {
                    count++;
                }
                if (set_bits > K) {
                    break;
                }
            }
        }
        return count;
    }

    private static int count1(String S, int K) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int prefix_sum = 0;
        for (int i=0;i<S.length();i++) {
            prefix_sum += (S.charAt(i) == '1') ? 1 : 0;
            if (prefix_sum == K) {
                count++;
            } else if (prefix_sum > K) {
                if (map.containsKey(prefix_sum - K)) {
                    count += map.get(prefix_sum - K);
                }
            }
            map.put(prefix_sum, map.getOrDefault(prefix_sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        String S = "100111010";
        int K = 3;
        System.out.println(count1(S,K));
    }
}
