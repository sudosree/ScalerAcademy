package arrays.practice;

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

    public static void main(String[] args) {
        int[] nums = {5, 6, 5, 7, 7, 8, 7, 8};
        int k = 13;
        System.out.println(findDistinctPairs(nums, k));
    }
}
