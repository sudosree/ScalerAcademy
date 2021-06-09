package twopointers.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairs {

    private static int findUniquePairs(int[] A, int k) {
        Arrays.sort(A);
        int count = 0;
        int left = 0, right = 1;
        while (right < A.length && left <= right) {
            // increase the range
            if (left == right || A[right] - A[left] < k) {
                right++;
            }
            // decrease the range
            else if (A[right] - A[left] > k) {
                left++;
            }
            // when A[right] - A[left] == k
            else {
                count++;
                left++;
                right++;
                // to handle the duplicate pairs count
                // do not count the duplicate pairs
                while (left < A.length && A[left] == A[left-1]) {
                    left++;
                }
                while (right < A.length && A[right] == A[right-1]) {
                    right++;
                }
            }
        }
        return count;
    }

    public int findPairs(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for (int n : map.keySet()) {
            int f = map.get(n);
            if (k > 0 && map.containsKey(n+k)) {
                count++;
            } else if (k == 0 && f > 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {3,1,4,1,5};
        System.out.println(findUniquePairs(A, 2));
    }
}
