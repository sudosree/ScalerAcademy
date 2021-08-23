package recursion.practice;

import java.util.*;

public class Permutations
{
    /**
     * TC = O(n * n!) (total there are n! permutations and to generate each permutation it takes O(n) time)
     * SC = O(n) (O(n) = choices list, O(n) = recursive stack)
     * @param nums
     * @return
     */
    private static List<List<Integer>> permute(int[] nums) {
        List<Integer> choices = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, choices, result);
        return result;
    }

    private static void permuteHelper(int[] nums, List<Integer> choices, List<List<Integer>> result) {
        if (choices.size() == nums.length) {
            result.add(new ArrayList<>(choices));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (!choices.contains(nums[i])) {
                choices.add(nums[i]);
                permuteHelper(nums, choices, result);
                choices.remove(choices.size()-1);
            }
        }
    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> choices = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, used, choices, result);
        return result;
    }

    private void permuteHelper(int[] nums, boolean[] used, List<Integer> choices, List<List<Integer>> result) {
        if (choices.size() == nums.length) {
            result.add(new ArrayList<>(choices));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            // if the ith element is marked as true then this element is already used, no need to consider it again
            if (used[i]) {
                continue;
            }
            used[i] = true;
            choices.add(nums[i]);
            permuteHelper(nums, used, choices, result);
            used[i] = false;
            choices.remove(choices.size()-1);
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
