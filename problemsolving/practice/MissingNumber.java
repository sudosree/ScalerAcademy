package problemsolving.practice;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        long sum = (long)(n * (n+1)) / 2;
        for (int i=0;i<n;i++) {
            sum -= nums[i];
        }
        return (int)sum;
    }

    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n-1] != n) {
            return n;
        }
        if (nums[0] != 0) {
            return 0;
        }
        for (int i=1;i<n;i++) {
            if (nums[i-1] + 1 != nums[i]) {
                return nums[i-1] + 1;
            }
        }
        return -1;
    }
}
