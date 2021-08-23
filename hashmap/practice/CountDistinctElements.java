package hashmap.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctElements {

    private static int[] distinctElements(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Map<Integer, Integer> map = new HashMap<>();
        // keep track of distinct characters
        int count = 0;
        for (int i=0;i<k;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            // count of distinct characters has increased
            if (map.get(nums[i]) == 1) {
                count++;
            }
        }
        ans[0] = count;
        for (int i=1; i<n-k+1; i++) {
            int prev = nums[i-1];
            int curr = nums[i+k-1];
            // decrease the freq of prev by 1
            map.put(prev, map.get(prev) - 1);
            // count of distinct characters has reduced
            if (map.get(prev) == 0) {
                count--;
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            // count of distinct characters has increased
            if (map.get(curr) == 1) {
                count++;
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4};
        int k = 2;
        System.out.println(Arrays.toString(distinctElements(nums, k)));
    }
}
