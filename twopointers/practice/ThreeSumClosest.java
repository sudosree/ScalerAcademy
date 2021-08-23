package twopointers.practice;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        // sort the array
        Arrays.sort(nums);
        int sum = 0, minDiff = Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++) {
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - currSum);
                if (diff < minDiff) {
                    minDiff = diff;
                    sum = currSum;
                }
                if (currSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {2147483647, -2147483648, -2147483648, 0, 1};
        int target = 0;
        System.out.println(threeSumClosest(nums, target));
    }
}
