package problemsolving.practice;

public class MinSwaps {

    private static int minSwaps(int[] nums) {
        int swaps = 0;
        for (int i=0;i<nums.length;i++) {
            int min = nums[i], minIdx = i;
            for (int j=i+1;j<nums.length;j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int t = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = t;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,4,3,2};
        System.out.println(minSwaps(nums));
    }
}
