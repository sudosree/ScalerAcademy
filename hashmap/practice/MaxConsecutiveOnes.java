package hashmap.practice;

public class MaxConsecutiveOnes
{
    private static int solve(int[] nums) {
        int maxLength = 0;
        for (int i=0;i<nums.length;i++) {
            int currLen = 0;
            for (int j=i;j<nums.length;j++) {
                if (nums[j] == 1) {
                    currLen++;
                    maxLength = Math.max(maxLength, currLen);
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }

    private static int solve1(int[] nums) {
        int[] maxConsecutiveOnes = new int[nums.length];
        maxConsecutiveOnes[0] = nums[0];
        for (int i=1;i<maxConsecutiveOnes.length;i++) {
            // starting of a new window
            if (nums[i-1] == 0 && nums[i] == 1) {
                maxConsecutiveOnes[i] = 1;
            } else {
                maxConsecutiveOnes[i] = maxConsecutiveOnes[i-1] + nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i=0;i<maxConsecutiveOnes.length;i++) {
            if (maxConsecutiveOnes[i]>max) {
                max = maxConsecutiveOnes[i];
            }
        }
        return max;
    }

    private static int solve2(int[] nums) {
        int maxLen = 0, currLen = 0;
        if (nums[0] == 1) {
            currLen = 1;
            maxLen = currLen;
        }
        for (int i=1;i<nums.length;i++) {
            // starting of a new window
            if (nums[i] == 1 && nums[i-1] == 0) {
                currLen = 1;
            } else {
                currLen += nums[i];
            }
            maxLen = Math.max(maxLen,currLen);
        }
        return maxLen;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,1,0,1,1,1,0,1};
        System.out.println(solve2(nums));
    }
}
