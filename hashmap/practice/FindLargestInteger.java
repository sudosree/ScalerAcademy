package hashmap.practice;

import java.util.HashSet;
import java.util.Set;

public class FindLargestInteger {

    private static int findLargest(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++) {
            if (nums[i] < 0) {
                set.add(nums[i]);
            }
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) {
                if (set.contains(-nums[i]) && nums[i] > ans) {
                    ans = nums[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -5, 2, -2, 5, 3};
        System.out.println(findLargest(nums));
    }
}
