package twopointers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    /**
     * TC = O(n^k-1) or O(n^3), SC = O(1)
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                threeSum(nums, i, target, res);
            }
        }
        return res;
    }

    private void threeSum(int[] nums, int i, int target, List<List<Integer>> res) {
        for (int j=i+1;j<nums.length;j++) {
            if (j == i+1 || nums[j] != nums[j-1]) {
                twoSum(nums, i, j, target, res);
            }
        }
    }

    private void twoSum(int[] nums, int i, int j, int target, List<List<Integer>> res) {
        int low = j+1, high = nums.length-1;
        while (low < high) {
            int sum = nums[i] + nums[j] + nums[low] + nums[high];
            if (sum == target) {
                res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                low++;
                while (low < high && nums[low] == nums[low-1]) {
                    low++;
                }
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
    }

    /**
     * TC = O(n^k-1) or O(n^3), SC = O(n)
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target, nums.length);
    }

    private static List<List<Integer>> kSum(int[] nums, int start, int k, int target, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == n) {
            return res;
        }
        // k remaining values to add to the sum and the avg of these values
        // is at least k
        long avgVal = target/k;
        // if the smallest value is > target/k or if the largest value is < target/k
        if (nums[start] > avgVal || nums[nums.length-1] < avgVal) {
            return res;
        }
        if (k == 2) {
            return twoSum(nums, start, target);
        }
        for (int i=start;i<n-k+1;i++) {
            if (i == start || nums[i] != nums[i-1]) {
                List<List<Integer>> temp = kSum(nums, i+1, k-1, target-nums[i], n);
                for (List<Integer> l : temp) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size()-1).addAll(l);
                }
            }
        }
        return res;
    }

    private static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int low = start, high = nums.length-1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                res.add(new ArrayList<>(Arrays.asList(nums[low], nums[high])));
                low++;
                while (low < high && nums[low] == nums[low-1]) {
                    low++;
                }
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        int[] nums = {1,0,-1,0,-2,2};
        int[] nums = {-1000000000,-1000000000,1000000000,-1000000000,-1000000000};
        int target = 294967296;
        System.out.println(fourSum1(nums, target));
    }
}
