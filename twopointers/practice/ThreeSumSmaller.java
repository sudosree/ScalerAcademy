package twopointers.practice;

import java.util.Arrays;

public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            count += twoSumSmaller(nums, i+1, target - nums[i]);
        }
        return count;
    }

    private int twoSumSmaller(int[] nums, int start, int target) {
        int left = start, right = nums.length-1;
        int count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
