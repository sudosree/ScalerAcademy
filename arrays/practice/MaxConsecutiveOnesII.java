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

    public int findMaxConsecutiveOnes2(int[] nums) {
        int maxOnes = 0;
        for (int i=0; i<nums.length; i++) {
            int countOnes = 0, countZeroes = 0;
            for (int j=i; j<nums.length; j++) {
                if (nums[j] == 1) {
                    countOnes++;
                } else if (nums[j] == 0 && countZeroes < 1) {
                    countZeroes++;
                    countOnes++;
                } else {
                    break;
                }
            }
            maxOnes = Math.max(maxOnes, countOnes);
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

    public int findMaxConsecutiveOnes3(int[] nums) {
        int maxOnes = 0, countZeroes = 0;
        int left = 0;
        for (int right=0; right<nums.length; right++) {
            if (nums[right] == 0) {
                countZeroes++;
            }
            // if the no. of zeroes in the current window is > 1 then
            // window is not valid, shrink the window
            while (countZeroes > 1) {
                if (nums[left] == 0) {
                    countZeroes--;
                }
                left++;
            }
            maxOnes = Math.max(maxOnes, right-left+1);
        }
        return maxOnes;
    }

}
