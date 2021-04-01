package arrays.practice;

public class MaxLenSubarryWithPositiveProduct {

    public int getMaxLen(int[] nums) {
        int max_len = 0;
        for (int i=0;i<nums.length;i++) {
            int negatives = 0;
            for (int j=i;j<nums.length;j++) {
                // if max is >= the length of the remaining element
                if (nums.length - i <= max_len) {
                    return max_len;
                }
                if (nums[j] == 0) {
                    break;
                }
                if (nums[j] < 0) {
                    negatives++;
                }
                // if the count of negative no.s are even then the subarray
                // will have positive product
                if (negatives % 2 == 0) {
                    max_len = Math.max(max_len,j-i+1);
                }
            }
        }
        return max_len;
    }
}
