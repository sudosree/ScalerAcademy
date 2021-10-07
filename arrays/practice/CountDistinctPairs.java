package arrays.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctPairs {

    private static int findDistinctPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i=0;i<nums.length;i++) {
            int num = k - nums[i];
            if (!map.containsKey(num)) {
                map.put(nums[i], 0);
            } else if (map.get(num) == 0) {
                map.put(num, map.get(num) + 1);
                count++;
            }
        }
        return count;
    }

    private static int countDistinctPairs1(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                count++;
                left++;
                right--;
                // skip the duplicate values
                while (left < nums.length && left < right && nums[left] == nums[left-1]) {
                    left++;
                }
                // skip the duplicate values
                while (right >= 0 && right > left && nums[right] == nums[right+1]) {
                    right--;
                }
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 7, 1, 8, 3};
        int k = 10;
        System.out.println(findDistinctPairs(nums, k));
        System.out.println(countDistinctPairs1(nums, k));
    }
}
