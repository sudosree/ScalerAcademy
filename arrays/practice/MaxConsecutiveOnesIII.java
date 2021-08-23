package arrays.practice;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int maxOnes = 0;
        for (int i=0;i<nums.length;i++) {
            int numZeroes = 0;
            for (int j=i;j<nums.length;j++) {
                if (nums[j] == 0) {
                    numZeroes++;
                }
                if (numZeroes > k) {
                    break;
                }
                maxOnes = Math.max(maxOnes, j-i+1);
            }
        }
        return maxOnes;
    }

    public int longestOnes1(int[] nums, int k) {
        int maxOnes = 0, numZeroes = 0;
        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                numZeroes++;
            }
            // if the window is invalid
            while (numZeroes > k) {
                if (nums[left] == 0) {
                    numZeroes--;
                }
                left++;
            }
            // if the window is valid
            maxOnes = Math.max(maxOnes, right-left+1);
            right++;
        }
        return maxOnes;
    }
}
