package arrays.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindContinousSum {

    private static List<List<Integer>> printContinousSum(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i=1;i<nums.length;i++) {
            prefix[i] = nums[i] + prefix[i-1];
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            for (int j=i;j<nums.length;j++) {
                if (i == 0) {
                    if (prefix[j] == k) {
                        ans.add(Arrays.asList(i, j));
                    }
                } else {
                    if (prefix[j] - prefix[i-1] == k) {
                        ans.add(Arrays.asList(i, j));
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,2,-2,-20,10};
        int k = -10;
        System.out.println(printContinousSum(nums, k));
    }
}
