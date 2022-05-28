package arrays.practice;

public class MoveZeroesToEnd {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        // left will keep track of all the non zero elements
        // and right will keep track of all the zero elements
        int left = 0, right = n-1;
        int[] ans = new int[n];

        for (int i=0; i<n; i++) {
            if (nums[i] == 0) {
                ans[right--] = nums[i];
            } else {
                ans[left++] = nums[i];
            }
        }
        for (int i=0; i<n; i++) {
            nums[i] = ans[i];
        }
    }

    public void moveZeroes1(int[] nums) {
        int n = nums.length;
        // find the position of first non zero element
        int i=0;
        while (i < n) {
            if (nums[i] != 0) {
                i++;
            } else {
                break;
            }
        }
        // left will keep track of all the non zero elements
        // and right will keep track of all the zero elements
        int left = i-1;
        int right = left + 1;
        while (right < n) {
            if (nums[right] != 0) {
                nums[left+1] = nums[right];
                left++;
                nums[right] = 0;
            }
            right++;
        }
    }

    public void moveZeroes2(int[] nums) {
        int n = nums.length;
        int lastSeenNonZero = -1, i = 0;
        while (i < n) {
            if (nums[i] != 0) {
                lastSeenNonZero++;
                // swap nums[lastSeenNonZero] and nums[i]
                int t = nums[lastSeenNonZero];
                nums[lastSeenNonZero] = nums[i];
                nums[i] = t;
            }
            i++;
        }
    }
}
