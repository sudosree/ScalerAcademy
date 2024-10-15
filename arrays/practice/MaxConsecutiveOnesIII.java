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

    public int longestOnes2(int[] nums, int k) {
        int maxOnes = 0, countZeroes = 0;
        for (int i=0; i<nums.length; i++) {
            countZeroes = 0;
            for (int j=i; j<nums.length; j++) {
                if (nums[j] == 0) {
                    countZeroes++;
                }
                if (countZeroes <= k) {
                    maxOnes = Math.max(maxOnes, j-i+1);
                } else {
                    break;
                }
            }
        }
        return maxOnes;
    }

    public int longestOnes3(int[] nums, int k) {
        int maxOnes = 0, countZeroes = 0;
        int left = 0;
        for (int right=0; right<nums.length; right++) {
            if (nums[right] == 0) {
                countZeroes++;
            }
            // if the no. of zeroes exceeds k in the current window then it is invalid
            // shrink the window until it becomes valid again
            while (countZeroes > k) {
                if (nums[left] == 0) {
                    countZeroes--;
                }
                left++;
            }
            // window is valid, record the current length and expand the window
            maxOnes = Math.max(maxOnes, right-left+1);
        }
        return maxOnes;
    }

    public int longestOnes4(int[] nums, int k) {
        int maxOnes = 0, countZeroes = 0;
        int left = 0;
        for (int right=0; right<nums.length; right++) {
            if (nums[right] == 0) {
                countZeroes++;
            }
            // if the no. of zeroes exceeds k in the current window then it is invalid
            // shrink the window only once as our goal is to find the window with max ones
            if (countZeroes > k) {
                if (nums[left] == 0) {
                    countZeroes--;
                }
                left++;
            }
            // window is valid, record the current length and expand the window
            maxOnes = Math.max(maxOnes, right-left+1);
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
