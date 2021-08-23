package twopointers.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairWithGivenDifference {

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = 1;
        while (left <= right && right < nums.length) {
            if (left == right) {
                right++;
                continue;
            }
            int diff = nums[right] - nums[left];
            if (diff < k) {
                right++;
            } else if (diff > k) {
                left++;
            } else {
                left++;
                right++;
                count++;
                while (left < nums.length && nums[left] == nums[left-1]) {
                    left++;
                }
                while (right < nums.length && nums[right] == nums[right-1]) {
                    right++;
                }
            }
        }
        return count;
    }

    public int findPairs1(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        int count = 0;
        for (int key : freq.keySet()) {
            int f = freq.get(key);
            if (k > 0 && freq.containsKey(key + k)) {
                count++;
            } else if (k == 0 && f > 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {-259, -825, 459, 825, 221, 870, 626, 934, 205, 783, 850, 398};
        int B = -42;
        System.out.println(findPairs(A, B));
    }
}
