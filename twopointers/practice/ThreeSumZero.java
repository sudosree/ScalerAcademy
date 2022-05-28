package twopointers.practice;

import java.util.*;

public class ThreeSumZero {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            // if the current element is > 0 then the remaining
            // elements cannot sum up to zero
            if (nums[i] > 0) {
                break;
            }
            // nums[i] != nums[i-1] -> to avoid duplicates
            if (i == 0 || nums[i] != nums[i-1]) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    /**
     * TC = O(nlogn + n^2) = O(n^2)
     * SC = O(logn) (based on sorting algo)
     * @param nums
     * @return
     */
    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int left = i+1, right = nums.length-1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                while (left < right && nums[left] == nums[left-1]) {
                    left++;
                }
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }

    /**
     * TC = O(nlogn + n^2) = O(n^2)
     * SC = O(n)
     * @param nums
     * @param i
     * @param res
     */
    private void twoSumHP(int[] nums, int i, List<List<Integer>> res) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j=i+1;j<nums.length;j++) {
            int complement = -nums[i] - nums[j];
            if (map.containsKey(complement)) {
                res.add(Arrays.asList(nums[i], complement, nums[j]));
                while (j+1 < nums.length && nums[j+1] == nums[j]) {
                    j++;
                }
            }
            map.put(nums[j], j);
        }
    }

    /**
     * TC = O(n^2), SC = O(n)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            if (dups.add(nums[i]));
            for (int j=i+1;j<nums.length;j++) {
                int complement = -nums[i] - nums[j];
                if (map.containsKey(complement) && map.get(complement) == i) {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplets);
                    res.add(triplets);
                }
                map.put(nums[j], i);
            }
        }
        return new ArrayList<>(res);
    }

    private static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    if (nums[i] + nums[j]+ nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum2(nums));
    }
}
