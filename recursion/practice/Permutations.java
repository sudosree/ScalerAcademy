package recursion.practice;

import java.util.*;

public class Permutations
{
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

    public static void main(String[] args)
    {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
