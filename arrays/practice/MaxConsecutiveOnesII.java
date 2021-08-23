package arrays.practice;

public class MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        for (int i=0;i<nums.length;i++) {
            boolean flipped = false;
            int count = 0;
            for (int j=i;j<nums.length;j++) {
                if (nums[j] == 1) {
                    count++;
                } else if (nums[j] == 0 && !flipped) {
                    flipped = true;
                    count++;
                } else {
                    break;
                }
            }
            maxOnes = Math.max(maxOnes, count);
        }
        return maxOnes;
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int maxOnes = 0, numZeroes = 0;
        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                numZeroes++;
            }

            // if the window is invalid then contract the window
            while (numZeroes == 2) {
                if (nums[left] == 0) {
                    numZeroes--;
                }
                left++;
            }

            // if the window is valid then extend the window
            maxOnes = Math.max(maxOnes, right-left+1);
            right++;
        }
        return maxOnes;
    }

}
