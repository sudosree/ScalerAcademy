package dynamicprogramming.practice;

public class DeleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001];
        for (int i=0; i<nums.length; i++) {
            sum[nums[i]] += nums[i];
        }
        for (int i=2; i<10001; i++) {
            sum[i] = Math.max(sum[i-2] + sum[i], sum[i-1]);
        }
        return sum[10000];
    }

    public int deleteAndEarn1(int[] nums) {
        int[] count = new int[10001];
        for (int i=0;i<nums.length;i++) {
            count[nums[i]]++;
        }
        // value of the previous answer that includes the no. that is
        // adjacent to x
        int using = 0;
        // value of the previous answer that doesn't include the no.
        // adjacent to x
        int avoid = 0;
        // previous no.
        int prev = -1;

        for (int i=0; i<10001; i++) {
            // the no. i is present in nums
            if (count[i] > 0) {
                // if i is adjacent to prev
                if (i-1 == prev) {
                    int take = i * count[i] + avoid;
                    int skip = Math.max(using, avoid);
                    using = take;
                    avoid = skip;
                }
                // i is not adjacent to prev
                else {
                    int take = i * count[i] + Math.max(using, avoid);
                    int skip = Math.max(using, avoid);
                    using = take;
                    avoid = skip;
                }
                // prev no. will now become i
                prev = i;
            }
        }
        return Math.max(using, avoid);
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2};
        System.out.println(deleteAndEarn(nums));
    }
}
