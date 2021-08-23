package recursion.practice;

import java.util.*;

public class PermutationsII
{
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> choices = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permuteHelper(nums, used, choices, result);
        return result;
    }

    private static void permuteHelper(int[] nums, boolean[] used, List<Integer> choices, List<List<Integer>> result) {
        if (choices.size() == nums.length) {
            result.add(new ArrayList<>(choices));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            // to skip duplicates
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            choices.add(nums[i]);
            permuteHelper(nums, used, choices, result);
            used[i] = false;
            choices.remove(choices.size()-1);
        }
    }

    private void permuteHelper1(int[] nums, boolean[] used, List<Integer> choices, List<List<Integer>> result) {
        if (choices.size() == nums.length) {
            result.add(new ArrayList<>(choices));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            choices.add(nums[i]);
            permuteHelper1(nums, used, choices, result);
            used[i] = false;
            choices.remove(choices.size()-1);
            while (i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {3,3,0,3};
        System.out.println(permuteUnique(nums));
    }
}
